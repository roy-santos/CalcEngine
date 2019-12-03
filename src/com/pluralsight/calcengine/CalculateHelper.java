package com.pluralsight.calcengine;

public class CalculateHelper {
    MathCommand command;
    double leftValue;
    double rightValue;
    double result;

    public void process(String statement) {
        //Breaks string down to individual parts
        //example input: add 1.0 2.0
        String[] parts = statement.split(" ");
        String commandString = parts[0]; //add
        leftValue = Double.parseDouble(parts[1]);
        rightValue = Double.parseDouble(parts[2]);

        //converts commandString to corresponding enum type
        setCommandFromString(commandString);

        //calls correct derived CalculatorBase class based on enum type
        CalculateBase calculator = null;
        switch (command) {
            case Add:
                calculator = new Adder(leftValue, rightValue);
                break;
            case Subtract:
                calculator = new Subtracter(leftValue, rightValue);
                break;
            case Multiply:
                calculator = new Multiplier(leftValue, rightValue);
                break;
            case Divide:
                calculator = new Divider(leftValue, rightValue);
                break;
        }

        calculator.calculate();
        result = calculator.getResult();
    }

    private void setCommandFromString(String commandString) {
        //add -> MathCommand.Add

        //converts enumeration to string value and compares it to the commandString
        if(commandString.equalsIgnoreCase(MathCommand.Add.toString()))
            command = MathCommand.Add;
        else if(commandString.equalsIgnoreCase(MathCommand.Subtract.toString()))
            command = MathCommand.Subtract;
        else if(commandString.equalsIgnoreCase(MathCommand.Multiply.toString()))
            command = MathCommand.Multiply;
        else if(commandString.equalsIgnoreCase(MathCommand.Divide.toString()))
            command = MathCommand.Divide;
    }
}