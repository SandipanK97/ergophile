package com.audit.customer;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.action.ActionForm;

public class FormBean extends ActionForm {

    private static long serialVersionUID = 1L;
    private String userId = "";
    private String password = "";
    private String isSubmit = "";
    private String custId = "";

    private String name = "";
    private String fname = "";
    private String mname = "";
    private String lname = "";
    private String dob = "";
    private String mobileNo = "";
    private String occupation = "";
    private String city = "";
    private String state = "";
    private String addressPin = "";
    private String aadharNo = "";
    private String panNo = "";
    private String isEkycDone = "";
    private String passportNo = "";

    private String accountNo = "";
    private String ifscCd = "";
    private String branch = "";
    private String location = "";
    private String accountType = "";
    private String status = "";
    private String aod = "";
    private String openingBalance = "";
    private String loanAccountNo = "";
    private String loanAmt = "";
    private String roi = "";
    private String tenure = "";

    private String modeOfTransaction = "";
    private String amtOfTransaction = "";
    private String transactionType = "";
    private String dot = "";

    private String transNo = "";
    private String balance = "";
    private String transDate = "";
    private String mot = "";
    private String crdbt = "";
    private String amt = "";
    private int updateNo = 0;

    private List<FormBean> list = null;

    private Double currBalance = 0.0;

    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the isSubmit
     */
    public String getIsSubmit() {
        return isSubmit;
    }

    /**
     * @param isSubmit the isSubmit to set
     */
    public void setIsSubmit(String isSubmit) {
        this.isSubmit = isSubmit;
    }

    /**
     * @return the custId
     */
    public String getCustId() {
        return custId;
    }

    /**
     * @param custId the custId to set
     */
    public void setCustId(String custId) {
        this.custId = custId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * @param fname the fname to set
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * @return the mname
     */
    public String getMname() {
        return mname;
    }

    /**
     * @param mname the mname to set
     */
    public void setMname(String mname) {
        this.mname = mname;
    }

    /**
     * @return the lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * @param lname the lname to set
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * @return the dob
     */
    public String getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * @return the mobileNo
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * @param mobileNo the mobileNo to set
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     * @return the occupation
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     * @param occupation the occupation to set
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the addressPin
     */
    public String getAddressPin() {
        return addressPin;
    }

    /**
     * @param addressPin the addressPin to set
     */
    public void setAddressPin(String addressPin) {
        this.addressPin = addressPin;
    }

    /**
     * @return the aadharNo
     */
    public String getAadharNo() {
        return aadharNo;
    }

    /**
     * @param aadharNo the aadharNo to set
     */
    public void setAadharNo(String aadharNo) {
        this.aadharNo = aadharNo;
    }

    /**
     * @return the panNo
     */
    public String getPanNo() {
        return panNo;
    }

    /**
     * @param panNo the panNo to set
     */
    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    /**
     * @return the isEkycDone
     */
    public String getIsEkycDone() {
        return isEkycDone;
    }

    /**
     * @param isEkycDone the isEkycDone to set
     */
    public void setIsEkycDone(String isEkycDone) {
        this.isEkycDone = isEkycDone;
    }

    /**
     * @return the passportNo
     */
    public String getPassportNo() {
        return passportNo;
    }

    /**
     * @param passportNo the passportNo to set
     */
    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    /**
     * @return the accountNo
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * @param accountNo the accountNo to set
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    /**
     * @return the ifscCd
     */
    public String getIfscCd() {
        return ifscCd;
    }

    /**
     * @param ifscCd the ifscCd to set
     */
    public void setIfscCd(String ifscCd) {
        this.ifscCd = ifscCd;
    }

    /**
     * @return the branch
     */
    public String getBranch() {
        return branch;
    }

    /**
     * @param branch the branch to set
     */
    public void setBranch(String branch) {
        this.branch = branch;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the accountType
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * @param accountType the accountType to set
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the aod
     */
    public String getAod() {
        return aod;
    }

    /**
     * @param aod the aod to set
     */
    public void setAod(String aod) {
        this.aod = aod;
    }

    /**
     * @return the openingBalance
     */
    public String getOpeningBalance() {
        return openingBalance;
    }

    /**
     * @param openingBalance the openingBalance to set
     */
    public void setOpeningBalance(String openingBalance) {
        this.openingBalance = openingBalance;
    }

    /**
     * @return the loanAccountNo
     */
    public String getLoanAccountNo() {
        return loanAccountNo;
    }

    /**
     * @param loanAccountNo the loanAccountNo to set
     */
    public void setLoanAccountNo(String loanAccountNo) {
        this.loanAccountNo = loanAccountNo;
    }

    /**
     * @return the loanAmt
     */
    public String getLoanAmt() {
        return loanAmt;
    }

    /**
     * @param loanAmt the loanAmt to set
     */
    public void setLoanAmt(String loanAmt) {
        this.loanAmt = loanAmt;
    }

    /**
     * @return the roi
     */
    public String getRoi() {
        return roi;
    }

    /**
     * @param roi the roi to set
     */
    public void setRoi(String roi) {
        this.roi = roi;
    }

    /**
     * @return the tenure
     */
    public String getTenure() {
        return tenure;
    }

    /**
     * @param tenure the tenure to set
     */
    public void setTenure(String tenure) {
        this.tenure = tenure;
    }

    /**
     * @return the modeOfTransaction
     */
    public String getModeOfTransaction() {
        return modeOfTransaction;
    }

    /**
     * @param modeOfTransaction the modeOfTransaction to set
     */
    public void setModeOfTransaction(String modeOfTransaction) {
        this.modeOfTransaction = modeOfTransaction;
    }

    /**
     * @return the amtOfTransaction
     */
    public String getAmtOfTransaction() {
        return amtOfTransaction;
    }

    /**
     * @param amtOfTransaction the amtOfTransaction to set
     */
    public void setAmtOfTransaction(String amtOfTransaction) {
        this.amtOfTransaction = amtOfTransaction;
    }

    /**
     * @return the transactionType
     */
    public String getTransactionType() {
        return transactionType;
    }

    /**
     * @param transactionType the transactionType to set
     */
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    /**
     * @return the dot
     */
    public String getDot() {
        return dot;
    }

    /**
     * @param dot the dot to set
     */
    public void setDot(String dot) {
        this.dot = dot;
    }

    /**
     * @return the transNo
     */
    public String getTransNo() {
        return transNo;
    }

    /**
     * @param transNo the transNo to set
     */
    public void setTransNo(String transNo) {
        this.transNo = transNo;
    }

    /**
     * @return the balance
     */
    public String getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(String balance) {
        this.balance = balance;
    }

    /**
     * @return the transDate
     */
    public String getTransDate() {
        return transDate;
    }

    /**
     * @param transDate the transDate to set
     */
    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }

    /**
     * @return the mot
     */
    public String getMot() {
        return mot;
    }

    /**
     * @param mot the mot to set
     */
    public void setMot(String mot) {
        this.mot = mot;
    }

    /**
     * @return the crdbt
     */
    public String getCrdbt() {
        return crdbt;
    }

    /**
     * @param crdbt the crdbt to set
     */
    public void setCrdbt(String crdbt) {
        this.crdbt = crdbt;
    }

    /**
     * @return the amt
     */
    public String getAmt() {
        return amt;
    }

    /**
     * @param amt the amt to set
     */
    public void setAmt(String amt) {
        this.amt = amt;
    }

    /**
     * @return the list
     */
    public List<FormBean> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<FormBean> list) {
        this.list = list;
    }

    /**
     * @return the updateNo
     */
    public int getUpdateNo() {
        return updateNo;
    }

    /**
     * @param updateNo the updateNo to set
     */
    public void setUpdateNo(int updateNo) {
        this.updateNo = updateNo;
    }

    /**
     * @return the currBalance
     */
    public Double getCurrBalance() {
        return currBalance;
    }

    /**
     * @param currBalance the currBalance to set
     */
    public void setCurrBalance(Double currBalance) {
        this.currBalance = currBalance;
    }

}
