import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    private static class CheckIn {
        String stationName;
        int time;

        CheckIn(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

    private static class JourneyData {
        double totalTime;
        int count;

        JourneyData(double totalTime, int count) {
            this.totalTime = totalTime;
            this.count = count;
        }
    }

    private Map<Integer, CheckIn> checkIns;
    private Map<String, JourneyData> travelData;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        travelData = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckIn(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckIn start = checkIns.remove(id);
        String routeKey = start.stationName + "->" + stationName;
        int timeTaken = t - start.time;

        JourneyData data = travelData.getOrDefault(routeKey, new JourneyData(0, 0));
        data.totalTime += timeTaken;
        data.count += 1;
        travelData.put(routeKey, data);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        JourneyData data = travelData.get(routeKey);
        return data.totalTime / data.count;
    }
}

