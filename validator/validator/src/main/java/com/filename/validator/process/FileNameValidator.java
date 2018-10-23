package com.filename.validator.process;

import com.filename.validator.result.FileNameValidationResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *The program validates the filename. If the file is invalid, it prints the error details along with the status of the file as passed or failed.
 *The file name format is matched with the below:
 *Test_<portfoliocode>_<ddmmyyyy>_<2digit-sequencenumber>.csv
 */
@Service

public class FileNameValidator {
    private final static Pattern FILENAME_PATTERN = Pattern.compile("^(Test)[_](A|B|C)[_](0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])(19|20)\\d\\d[.](csv)$");
    private final static Pattern FILE_FORMAT_PATTERN = Pattern.compile("[.](csv)$");
    private final static Pattern DATE_FORMAT_PATTERN = Pattern.compile("(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])(19|20)\\d\\d");
    private final static Pattern PREFIX_PATTERN = Pattern.compile("^(Test)");
    private final Logger log = LoggerFactory.getLogger(getClass());

    public FileNameValidationResult validateFileName(String filename) {

        Matcher matcher = FILENAME_PATTERN.matcher(filename);
        FileNameValidationResult result;
        String message;
        if (!matcher.matches()) {
            if(!filename.contains("_")){
                message = "File '"+filename+"' failed validation. File format should be 'Test_<portfoliocode>_<ddmmyyyy>_<2digit-sequencenumber>.csv'";
                log.info(message);
                result = new FileNameValidationResult(message,"Failed");
            }
            else if (PREFIX_PATTERN.matcher(filename).find()) {
                if (FILE_FORMAT_PATTERN.matcher(filename).find()) {
                    if (DATE_FORMAT_PATTERN.matcher(filename).find()) {
                        message = "File '"+filename+"' failed validation. PortfolioCode should be A/B/C found '"+filename.split("_")[1].split("_")[0]+"'.";
                        log.info(message);
                        result = new FileNameValidationResult(message,"Failed");
                    }
                    else{
                        message = "File '"+filename+"' failed validation. Valuation Date is not a valid date format 'ddmmyyyy'.";
                        log.info(message);
                        result = new FileNameValidationResult(message,"Failed");
                    }
                }
                else{
                    message = "File '"+filename+"' failed validation. Invalid File format.Expected 'csv' found '"+filename.substring(filename.lastIndexOf(".")+1)+"'.";
                    log.info(message);
                    result = new FileNameValidationResult(message,"Failed");
                }
            } else {
                message = "File '"+filename+"' failed validation. Prefix for the file should be 'Test' found '"+filename.split("_")[0]+"'.";
                log.info(message);
                result = new FileNameValidationResult(message,"Failed");
            }
            return result;
        }
        return new FileNameValidationResult("File '"+filename+"' passed validation.","Passed");
    }

}