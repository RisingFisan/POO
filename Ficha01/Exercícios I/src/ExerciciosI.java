public class ExerciciosI {
    public int dayOfTheWeek(int day, int month, int year) {
        int totalDays = (int)((year - 1900) * 365.25);
        if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0) && month < 3) totalDays--;
        for(int i = month; i > 0; i--) {
            if(i == 2) totalDays += 28;
            else if(i == 4 || i == 6 || i == 9 || i == 11) totalDays += 30;
            else totalDays += 31;
        }
        return totalDays % 7;
    }
}
