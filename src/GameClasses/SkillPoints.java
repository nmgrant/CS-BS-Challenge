package GameClasses;

public class SkillPoints {

   private final int LEARNING_CHIP = 0;
   private final int CRAFT_CHIP = 1;
   private final int INTEGRITY_CHIP = 2;

   private int learningChips;
   private int craftChips;
   private int integrityChips;

   public SkillPoints(int chipType) {
      if (chipType == 0) {
         this.learningChips = 1;
         this.craftChips = 0;
         this.integrityChips = 0;
      } else if (chipType == 1) {
         this.learningChips = 0;
         this.craftChips = 1;
         this.integrityChips = 0;
      } else {
         this.learningChips = 0;
         this.craftChips = 0;
         this.integrityChips = 1;
      }
   }

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
   
   public void adjustSkillPoints(SkillPoints skillPoints) {
       learningChips += skillPoints.getLearningChips();
       craftChips += skillPoints.getCraftChips();
       integrityChips += skillPoints.getIntegrityChips();
   }

   @Override
   public int hashCode() {
      int hash = 5;
      hash = 29 * hash + this.learningChips;
      hash = 29 * hash + this.craftChips;
      hash = 29 * hash + this.integrityChips;
      return hash;
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }
      if (getClass() != obj.getClass()) {
         return false;
      }
      final SkillPoints other = (SkillPoints) obj;
      if (this.learningChips < other.learningChips) {
         return false;
      }
      if (this.craftChips < other.craftChips) {
         return false;
      }
      if (this.integrityChips < other.integrityChips) {
         return false;
      }
      return true;
   }
   
   @Override
   public String toString() {
       return " Learning Chips: " + learningChips + " Craft Chips: " + craftChips
        + " Integrity Chips: " + integrityChips + "\n";
   }

}
