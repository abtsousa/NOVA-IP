public class WaterStation {
    private Crop crop1;
    private Crop crop2;
    private int numDaysForBoth;
    private int numDaysFor1;
    private int numDaysFor2;

    public WaterStation(Crop c1, Crop c2) {
        crop1 = c1;
        crop2 = c2;
    }

    public void registerDay(String day) {
        int numDrops = countDrops(day);
        if (crop1.isGoodDay(numDrops) && crop2.isGoodDay(numDrops)) {
            numDaysForBoth++;
        }
        if (crop1.isGoodDay(numDrops)) {
            numDaysFor1++;
        }
        if (crop2.isGoodDay(numDrops)) {
            numDaysFor2++;
        }
    }

    public int countDrops(String day) {
        int drops=0;
        for (int i=0;i<day.length();i++) {
            if (day.charAt(i) == '1') {
                drops++;
            }
        }
        return drops;
    }

    public boolean areCropsEquivalent() {
        return numDaysFor1 == numDaysFor2;
    }

    public String getBestCropName() {
        if (numDaysFor1 > numDaysFor2)
            return crop1.getName();
        else if (numDaysFor2 > numDaysFor1)
            return crop2.getName();
        else return null;
    }

    public int getNumDaysForBoth() {
        return numDaysForBoth;
    }

    public int getNumDaysFor1() {
        return numDaysFor1;
    }

    public int getNumDaysFor2() {
        return numDaysFor2;
    }
}
