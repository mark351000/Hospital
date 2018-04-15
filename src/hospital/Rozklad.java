package hospital;


public class Rozklad {
    private String [][] TimeTable = new String[11][8];

    public Rozklad(String[][] timeTable) {
        TimeTable = timeTable;
    }

    public Rozklad() {
        this.getTimeTable()[0][0]="       Date";
        this.getTimeTable()[0][1]="  Monday  ";
        this.getTimeTable()[0][2]="  Tuesday ";
        this.getTimeTable()[0][3]=" Wednesday";
        this.getTimeTable()[0][4]=" Thursday ";
        this.getTimeTable()[0][5]="  Friday  ";
        this.getTimeTable()[0][6]=" Saturday ";
        this.getTimeTable()[0][7]="  Sunday  ";
        this.getTimeTable()[1][0]="  8.00-9.00";
        this.getTimeTable()[2][0]=" 9.00-10.00";
        this.getTimeTable()[3][0]="10.00-11.00";
        this.getTimeTable()[4][0]="11.00-12.00";
        this.getTimeTable()[5][0]="12.00-13.00";
        this.getTimeTable()[6][0]="13.00-14.00";
        this.getTimeTable()[7][0]="14.00-15.00";
        this.getTimeTable()[8][0]="15.00-16.00";
        this.getTimeTable()[9][0]="16.00-17.00";
        this.getTimeTable()[10][0]="17.00-18.00";

    }

    public String[][] getTimeTable() {
        return TimeTable;
    }

    public void setTimeTable(String[][] timeTable) {
        TimeTable = timeTable;
    }
    public void setVisitInTimeTable(String surname, int day, int hour){
        String goodSurbame = surname;
        for (int i = surname.length(); i < 10; i++ ) goodSurbame+=" ";
        this.getTimeTable()[hour][day] = goodSurbame;
    }

    @Override
    public String toString() {
        String result="";
        for (int i = 0; i<this.getTimeTable().length; i++){
            for (int j =0; j<this.getTimeTable()[0].length; j++){
                result+=(this.getTimeTable()[i][j]==(null))? "    fre    ": this.getTimeTable()[i][j]+" ";
            }
            result +="\n";
        }
        return result;
    }
}
