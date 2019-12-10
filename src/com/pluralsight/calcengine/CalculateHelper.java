//package com.pluralsight.calcengine;
//
//public class CalculateHelper {
//    private static final char ADD_SYMBOL = '+';
//    private static final char SUBTRACT_SYMBOL = '-';
//    private static final char MULTIPLY_SYMBOL = '*';
//    private static final char DIVIDE_SYMBOL = '/';
//
//    MathCommand command;
//    double leftValue;
//    double rightValue;
//    double result;
//
//    public void process(String statement) throws InvalidStatementException  {
//        //Breaks string down to individual parts
//        //example input: add 1.0 2.0
//        String[] parts = statement.split(" ");
//
//        //checks if input statement has 3 parts, otherwise throw exception
//        if(parts.length != 3)
//            throw new InvalidStatementException("Incorrect number of fields", statement);
//
//        String commandString = parts[0]; //add
//
//        //check if number format of input statement is correct, else throws exception
//        try {
//            leftValue = Double.parseDouble(parts[1]);
//            rightValue = Double.parseDouble(parts[2]);
//        } catch (NumberFormatException e) {
//            throw new InvalidStatementException("Non-numeric data", statement, e);
//        }
//
//        //converts commandString to corresponding enum type
//        setCommandFromString(commandString);
//
//        //check to see if command is still null, means error in command string
//        if(command == null) {
//            throw new InvalidStatementException("Invalid command", statement);
//        }
//
//        //calls correct derived CalculatorBase class based on enum type
//        CalculateBase calculator = null;
//        switch (command) {
//            case Add:
//                calculator = new Adder(leftValue, rightValue);
//                break;
//            case Subtract:
//                calculator = new Subtracter(leftValue, rightValue);
//                break;
//            case Multiply:
//                calculator = new Multiplier(leftValue, rightValue);
//                break;
//            case Divide:
//                calculator = new Divider(leftValue, rightValue);
//                break;
//        }
//
//        calculator.calculate();
//        result = calculator.getResult();
//    }
//
//    private void setCommandFromString(String commandString) {
//        //add -> MathCommand.Add
//
//        //converts enumeration to string value and compares it to the commandString
//        if(commandString.equalsIgnoreCase(MathCommand.Add.toString()))
//            command = MathCommand.Add;
//        else if(commandString.equalsIgnoreCase(MathCommand.Subtract.toString()))
//            command = MathCommand.Subtract;
//        else if(commandString.equalsIgnoreCase(MathCommand.Multiply.toString()))
//            command = MathCommand.Multiply;
//        else if(commandString.equalsIgnoreCase(MathCommand.Divide.toString()))
//            command = MathCommand.Divide;
//    }
//
//    //Override the object class' toString() method in order to print out the proper string when printing out a class instance.
//    @Override
//    public String toString() {
//        //1.0 + 2.0 = 3.0
//        char symbol = ' ';
//        switch (command) {
//            case Add:
//                symbol = ADD_SYMBOL;
//                break;
//            case Subtract:
//                symbol = SUBTRACT_SYMBOL;
//                break;
//            case Multiply:
//                symbol = MULTIPLY_SYMBOL;
//                break;
//            case Divide:
//                symbol = DIVIDE_SYMBOL;
//                break;
//        }
//
//        //Build output string
//        StringBuilder sb = new StringBuilder(20);
//        sb.append(leftValue);
//        sb.append(' ');
//        sb.append(symbol);
//        sb.append(' ');
//        sb.append(rightValue);
//        sb.append(" = ");
//        sb.append(result);
//
//        return sb.toString();
//    }
//}
