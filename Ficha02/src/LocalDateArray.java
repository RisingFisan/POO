import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

public class LocalDateArray {
    private LocalDate[] dates;
    private int numElems;

    public LocalDateArray(int size) {
        this.dates = new LocalDate[size];
        this.numElems = 0;
    }

    public void insereData(LocalDate data) {
        if(this.numElems < this.dates.length)
            this.dates[this.numElems++] = data;
    }

    public LocalDate dataMaisProxima(LocalDate data) {
        long shortestDiff = Math.abs(DAYS.between(data, this.dates[0]));
        LocalDate closestDate = this.dates[0];
        for(int i = 0; i < this.numElems; i++) {
            LocalDate dataX = this.dates[i];
            long daysBetween = Math.abs(DAYS.between(data, dataX));
            if(daysBetween < shortestDiff) {
                closestDate = dataX;
                shortestDiff = daysBetween;
            }
        }
        return closestDate;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("");
        for(int i = 0; i < this.numElems; i++) {
            LocalDate date = this.dates[i];
            sb.append(date.toString()).append("\n");
        }
        return sb.toString();
    }
}
