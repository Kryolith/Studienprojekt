/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package studienprojekt;

/**
 *
 * @author Sebastian
 */
public class SpaceUsageRule {
    
    private String group;
    private String rule;
    private String value;
    
    public SpaceUsageRule(String ruleString) {
        /* TODO: String parsen */
    }
    
    public SpaceUsageRule(String group, String rule, String value) {
        this.group = group;
        this.rule = rule;
        this.value = value;
    }
    
    public SpaceUsageRule(String rule, String value) {
        this.group = "";
        this.rule = rule;
        this.value = value;
    }

    /**
     * @return the group
     */
    public String getGroup() {
        return group;
    }

    /**
     * @param group the group to set
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * @return the rule
     */
    public String getRule() {
        return rule;
    }

    /**
     * @param rule the rule to set
     */
    public void setRule(String rule) {
        this.rule = rule;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }
    
}
