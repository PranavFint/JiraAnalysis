package com.demo.listner;

//TestListener.java
import com.demo.utility.JiraCreateIssue;
import com.demo.utility.JiraServiceProvider;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        boolean islogIssue = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(JiraCreateIssue.class).isCreateIssue();
        if (islogIssue) {
           JiraServiceProvider JiraServiceProvider = new JiraServiceProvider("https://pranav2001.atlassian.net",

                    "kbpranav123@gmail.com", "ATATT3xFfGF0urs8aGOZ7at97tjhZsgCxoTV-vAEFORSfDaYfXUP6hqbGPYqi6YCtDHQC2UO_vp9DJ_ArZAdHEZcwJ7hlDa5AYrShrLc900dXpmr1ZVmVpbT05-5U29_4plX6QiibwGedCAKTL9g7v3LwXbg70wrumvd1iupmcyP79ozDS3Fsv0=58D9145C",
                    "IN");

            String issueDescription = "Failure Reason-1 from Automation Testing\n\n" + result.getThrowable().getMessage()

                    + "\n";
            issueDescription.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));

            String issueSummary = "New Issue -1 Summary"+result.getMethod().getConstructorOrMethod().getMethod().getName()

                    + " Failed in Automation Testing";

           JiraServiceProvider.createJiraIssue("Bug", issueSummary, issueDescription, "Automated Testing");
        }
    }
    @Override
    public void onTestSkipped(ITestResult result) {

        // TODO Auto-generated method stub
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

        // TODO Auto-generated method stub

    }

    @Override

    public void onStart(ITestContext context) {

        // TODO Auto-generated method stub
    }

    @Override

    public void onFinish(ITestContext context) {

        // TODO Auto-generated method stub
    }

    @Override

    public void onTestStart(ITestResult result) {

        // TODO Auto-generated method stub

    }

    @Override

    public void onTestSuccess(ITestResult result) {

        // TODO Auto-generated method stub

    }

}

