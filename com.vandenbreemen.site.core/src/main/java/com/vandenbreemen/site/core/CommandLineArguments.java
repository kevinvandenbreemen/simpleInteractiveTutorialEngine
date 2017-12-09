package com.vandenbreemen.site.core;

import java.util.*;

/**
 * Simple command line arguments parser
 */
public class CommandLineArguments {

    /**
     * Arguments that were parsed
     */
    private Map<String, String> parsedArguments;

    /**
     * Construct command line arguments based on the given input
     * @param strings
     */
    public CommandLineArguments(String[] strings) {
        this.parsedArguments = new HashMap<>();
        Iterator<String> iterator = Arrays.asList(strings).iterator();
        if(!iterator.hasNext()){
            return;
        }
        parseNextArgument(iterator.next(), iterator);
    }

    /**
     * Parse the next argument (arg name and value)
     * @param  arg  Argument
     * @param argIterator
     */
    private void parseNextArgument(String arg, Iterator<String> argIterator){
        String finalArg = arg.replaceAll("[-]+", "");
        Optional<String> parsedValue = parseValueOf(argIterator);
        parsedArguments.put(finalArg, parsedValue.isPresent() ? parsedValue.get().trim() : "");
    }

    /**
     * Parse value of the current argument
     * @param argIterator
     * @return
     */
    private Optional<String> parseValueOf(Iterator<String> argIterator) {
        StringBuilder bld = new StringBuilder();
        while(argIterator.hasNext()){
            String value = argIterator.next();
            if(value.startsWith("-")){
                parseNextArgument(value, argIterator);  //  Go to the next arg!
                return Optional.ofNullable(bld.toString());
            }
            bld.append(" ").append(value);
        }

        return Optional.ofNullable(bld.toString());

    }

    /**
     *
     * @param argument
     * @return
     */
    public Optional<String> valueOf(String argument) {
        return Optional.ofNullable(this.parsedArguments.get(argument));
    }
}
