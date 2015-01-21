

package gov.nist.healthcare.ttt.database.xdr;

import gov.nist.healthcare.ttt.database.xdr.XDRRecordInterface.CriteriaMet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created Oct 10, 2014 2:08:49 PM
 * @author mccaffrey
 */
public class XDRTestStepImpl implements XDRTestStepInterface {

    private String xdrTestStepID = null;
    private String timestamp = null;    
    private String messageId = null;
    private String name = null;
    private List<XDRReportItemInterface> reportItems = null;
    private XDRSimulatorInterface simulator = null;
    private CriteriaMet criteriaMet = null;
    private String hostname = null;
    
    public XDRTestStepImpl() {
        this.setXdrReportItems(new ArrayList<XDRReportItemInterface>());
    }
    
    /**
     * @return the xdrTestStepID
     */
    public String getXdrTestStepID() {
        return xdrTestStepID;
    }

    /**
     * @param xdrTestStepID the xdrTestStepID to set
     */
    public void setXdrTestStepID(String xdrTestStepID) {
        this.xdrTestStepID = xdrTestStepID;
    }

    /**
     * @return the timestamp
     */
    @Override
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    @Override
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }


    /**
     * @return the messageId
     */
    @Override
    public String getMessageId() {
        return messageId;
    }

    /**
     * @param messageId the messageId to set
     */
    @Override
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    /**
     * @return the reportItems
     */
    @Override
    public List<XDRReportItemInterface> getXdrReportItems() {
        return reportItems;
    }

    /**
     * @param reportItems the reportItems to set
     */
    @Override
    public void setXdrReportItems(List<XDRReportItemInterface> reportItems) {
        this.reportItems = reportItems;
    }

    @Override
    public XDRSimulatorInterface getXdrSimulator() {
        return simulator;
    }

    @Override
    public void setXdrSimulator(XDRSimulatorInterface xdrSimulator) {
        this.simulator = xdrSimulator;
    }

    /**
     * @return the criteriaMet
     */
    public CriteriaMet getCriteriaMet() {
        return criteriaMet;
    }

    /**
     * @param criteriaMet the criteriaMet to set
     */
    public void setCriteriaMet(CriteriaMet criteriaMet) {
        this.criteriaMet = criteriaMet;
    }

    /**
     * @return the name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the hostname
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * @param hostname the hostname to set
     */
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }


    
}
