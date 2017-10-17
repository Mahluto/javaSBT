package ru.sbt.bit.ood.solid.homework;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class SalaryHtmlReportNotifier {

    private Connection connection;
    private static final String MAIL_GOOGLE_COM = "mail.google.com";
    private static final String SENDING_SUBJECT = "Monthly department salary report";

    public SalaryHtmlReportNotifier(Connection databaseConnection) {

        this.connection = databaseConnection;
    }

    public void sendSalaryReport (ReportParameters reportPar) {
        ResultSet queryResults = this.getDataFromDB(reportPar);
        StringBuilder htmlForSend = this.createHtml(queryResults);
        this.sendData(reportPar.recipients);

    }
    private void sendData(String recipients) {

        try {
            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            mailSender.setHost(MAIL_GOOGLE_COM);
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(recipients);
            helper.setText(resultingHtml.toString(), true);
            helper.setSubject(SENDING_SUBJECT);
            mailSender.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    private ResultSet getDataFromDB(ReportParameters reportPar) {
        ResultSet results = null;
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "select emp.id as emp_id, emp.name as amp_name, sum(salary) " +
                            "as salary from employee emp left join " +
                            "salary_payments sp on emp.id = sp.employee_id where emp.department_id = ? and" +
                            " sp.date >= ? and sp.date <= ? group by emp.id, emp.name"
            );
            ps.setString(0, reportPar.departmentId);
            ps.setDate(1, new java.sql.Date(reportPar.dateFrom.toEpochDay()));
            ps.setDate(2, new java.sql.Date(reportPar.dateTo.toEpochDay()));
            results = ps.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    private StringBuilder createHtml(ResultSet results) {
        StringBuilder resultingHtml = new StringBuilder();
        resultingHtml.append("<html><body><table><tr><td>Employee</td><td>Salary</td></tr>");
        double totals = 0;
        try {
            while (results.next()) {
                resultingHtml.append("<tr>");
                resultingHtml.append("<td>").append(results.getString("emp_name")).append("</td>");
                resultingHtml.append("<td>").append(results.getDouble("salary")).append("</td>");
                resultingHtml.append("</tr>");
                totals += results.getDouble("salary");
            }
            resultingHtml.append("<tr><td>Total</td><td>").append(totals).append("</td></tr>");
            resultingHtml.append("</table></body></html>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultingHtml;
    }
}