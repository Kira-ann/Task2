package org.example;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.IOException;

public class Parser {
    @Option(name = "-z", usage = "package", forbids = {"-u"})
    private Boolean pack = false;


    @Option(name = "-u", usage = "unpackage", forbids = {"-z"})
    private Boolean unpack = false;

    @Option(name = "-out", usage = "outputFile")
    private String outputFile;

    @Argument(required = true, metaVar = "inputFile", usage = "inputFile")
    private String inputFile;

    public void launch(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
            Main h = new Main(inputFile);
            h.solve(unpack, pack, outputFile);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            parser.printUsage(System.err);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
