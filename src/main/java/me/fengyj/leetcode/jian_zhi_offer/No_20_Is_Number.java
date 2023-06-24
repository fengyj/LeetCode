package me.fengyj.leetcode.jian_zhi_offer;

public class No_20_Is_Number {

    public static boolean isNumber(String s) {

        if (s == null)
            return false;
        try {
            ValidationState state = ValidationState.Empty;
            for (char c : s.toCharArray()) {
                state = state.next(ValidNumberInputs.getInput(c));
            }
            return ValidationState.isFinalState(state);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public enum ValidNumberInputs {

        Space,
        E,
        Dot,
        Sign,
        Digit;

        public static ValidNumberInputs getInput(char c) {

            if (c == ' ')
                return Space;
            else if (c == 'E' || c == 'e')
                return E;
            else if (c == '.')
                return Dot;
            else if (c == '+' || c == '-')
                return Sign;
            else if (c >= '0' && c <= '9')
                return Digit;
            else
                throw new IllegalArgumentException(String.format("Invalid char '%s' in the input string.", c));
        }
    }

    public enum ValidationState {

        Empty {
            @Override
            public ValidationState next(ValidNumberInputs input) {

                switch (input) {
                    case Space:
                        return LeadingSpaces;
                    case Sign:
                        return NumberSign;
                    case Dot:
                        return Dot;
                    case Digit:
                        return Integer;
                    default:
                        throw new IllegalArgumentException(String.format("Current state is %s, cannot accept input %s.",
                                this.name(), input.name()));
                }
            }
        },
        LeadingSpaces {
            @Override
            public ValidationState next(ValidNumberInputs input) {

                switch (input) {
                    case Space:
                        return LeadingSpaces;
                    case Sign:
                        return NumberSign;
                    case Dot:
                        return Dot;
                    case Digit:
                        return Integer;
                    default:
                        throw new IllegalArgumentException(String.format("Current state is %s, cannot accept input %s.",
                                this.name(), input.name()));
                }
            }
        },
        NumberSign {
            @Override
            public ValidationState next(ValidNumberInputs input) {

                switch (input) {
                    case Dot:
                        return Dot;
                    case Digit:
                        return Integer;
                    default:
                        throw new IllegalArgumentException(String.format("Current state is %s, cannot accept input %s.",
                                this.name(), input.name()));
                }
            }
        },
        Integer {
            @Override
            public ValidationState next(ValidNumberInputs input) {
                switch (input) {
                    case Dot:
                        return Decimal;
                    case Digit:
                        return Integer;
                    case E:
                        return E;
                    case Space:
                        return EndingSpaces;
                    default:
                        throw new IllegalArgumentException(String.format("Current state is %s, cannot accept input %s.",
                                this.name(), input.name()));
                }
            }
        },
        Dot {
            @Override
            public ValidationState next(ValidNumberInputs input) {
                switch(input) {
                    case Digit: return Decimal;
                    default:
                        throw new IllegalArgumentException(String.format("Current state is %s, cannot accept input %s.",
                                this.name(), input.name()));
                }
            }
        },
        Decimal {
            @Override
            public ValidationState next(ValidNumberInputs input) {
                switch (input) {
                    case Digit:
                        return Decimal;
                    case E:
                        return E;
                    case Space:
                        return EndingSpaces;
                    default:
                        throw new IllegalArgumentException(String.format("Current state is %s, cannot accept input %s.",
                                this.name(), input.name()));
                }
            }
        },
        E {
            @Override
            public ValidationState next(ValidNumberInputs input) {
                switch (input) {
                    case Sign:
                        return ESign;
                    case Digit:
                        return EInteger;
                    default:
                        throw new IllegalArgumentException(String.format("Current state is %s, cannot accept input %s.",
                                this.name(), input.name()));
                }
            }
        },
        ESign {
            @Override
            public ValidationState next(ValidNumberInputs input) {
                switch (input) {
                    case Digit:
                        return EInteger;
                    default:
                        throw new IllegalArgumentException(String.format("Current state is %s, cannot accept input %s.",
                                this.name(), input.name()));
                }
            }
        },
        EInteger {
            @Override
            public ValidationState next(ValidNumberInputs input) {
                switch (input) {
                    case Digit:
                        return EInteger;
                    case Space:
                        return EndingSpaces;
                    default:
                        throw new IllegalArgumentException(String.format("Current state is %s, cannot accept input %s.",
                                this.name(), input.name()));

                }
            }
        },
        EndingSpaces {
            @Override
            public ValidationState next(ValidNumberInputs input) {
                switch (input) {
                    case Space:
                        return EndingSpaces;
                    default:
                        throw new IllegalArgumentException(String.format("Current state is %s, cannot accept input %s.",
                                this.name(), input.name()));
                }
            }
        };

        public abstract ValidationState next(ValidNumberInputs input);

        public static boolean isFinalState(ValidationState state) {

            return state == Integer || state == Decimal || state == EInteger || state == EndingSpaces;
        }
    }
}
