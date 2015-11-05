package main;


public class SkillPoints {
    private int learningChips;
    private int craftChips;
    private int integrityChips;
    
    public SkillPoints(int learningChips, int craftChips, int integrityChips) {
        this.learningChips = learningChips;
        this.craftChips = craftChips;
        this.integrityChips = integrityChips;
    }

    public int getLearningChips() {
        return learningChips;
    }

    public void setLearningChips(int learningChips) {
        this.learningChips = learningChips;
    }

    public int getCraftChips() {
        return craftChips;
    }

    public void setCraftChips(int craftChips) {
        this.craftChips = craftChips;
    }

    public int getIntegrityChips() {
        return integrityChips;
    }

    public void setIntegrityChips(int integrityChips) {
        this.integrityChips = integrityChips;
    }
}
