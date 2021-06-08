package Utilities;

import java.util.Map;

public interface FlowControl {
  void addContest(int index);
  void move(int index_from, int index_to);
  void perform_competition();
  Map <CompetitorsTypes, String> getResults();
}
