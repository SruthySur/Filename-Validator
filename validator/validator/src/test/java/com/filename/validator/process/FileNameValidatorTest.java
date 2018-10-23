package com.filename.validator.process;

import org.junit.Assert;
import org.junit.Test;

public class FileNameValidatorTest {

    private FileNameValidator fileNameValidator;

    @Test
    public void validateFileName_Passed_Test() {

        fileNameValidator = new FileNameValidator();
        Assert.assertEquals("Passed",fileNameValidator.validateFileName("Test_A_07121987.csv").getStatus());
    }
    @Test
    public void validateFileName_Failed_Test() {

        fileNameValidator = new FileNameValidator();
        Assert.assertEquals("Failed",fileNameValidator.validateFileName("Test.txt").getStatus());
    }
    @Test
    public void validateFileName_PortfolioCode_Test() {

        fileNameValidator = new FileNameValidator();
        Assert.assertEquals("Failed",fileNameValidator.validateFileName("Test_E_07121987.csv").getStatus());
    }
    @Test
    public void validateFileName_DateFormat_Test() {

        fileNameValidator = new FileNameValidator();
        Assert.assertEquals("Failed",fileNameValidator.validateFileName("Test_A_13121987.csv").getStatus());
    }
    @Test
    public void validateFileName_Prefix_Test() {

        fileNameValidator = new FileNameValidator();
        Assert.assertEquals("Failed",fileNameValidator.validateFileName("Hello_A_07121987.csv").getStatus());
    }
    @Test
    public void validateFileName_FileFormat_Test() {

        fileNameValidator = new FileNameValidator();
        Assert.assertEquals("Failed",fileNameValidator.validateFileName("Test_A_07121987.txt").getStatus());
    }
}