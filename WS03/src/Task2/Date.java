

package Task2;

public class Date {
    private String m_monthStr;
    private int m_monthInt, m_day, m_year;
    private static int mIdx;
    private static final int[] monthIntList = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}; // to prevent a massive switch case block
    private static final String[] monthStrList = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
    private static final int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Date(int month, int day, int year) {
        if (validDate(month, day, year) && (mIdx >= 0 && mIdx < monthIntList.length)) {
            m_monthInt = month;
            m_day = day;
            m_year = year;
            m_monthStr = monthStrList[mIdx];
        }
    }

    public Date(String month, int day, int year) {
        if (validDate(month, day, year) && (mIdx >= 0 && mIdx < monthIntList.length)) {
            m_monthStr = monthStrList[mIdx];
            m_monthInt = monthIntList[mIdx];
            m_day = day;
            m_year = year;
        }
    }

    public Date(int day, int year) {
        if (validDate(day, year)) {
            m_day = day;
            m_year = year;
        }
    }

    private boolean validDate(int month, int day, int year) {
        for (int i = 0; i < monthIntList.length; i++) {
            if (month == monthIntList[i] && (day >= 1 && day <= daysInMonth[i]) && (year >= 0 && year <= 2100)) {
                mIdx = i;
                return true;
            }
        }
        return false;
    }

    private boolean validDate(String month, int day, int year) {
        for (int i = 0; i < monthIntList.length; i++) {
            if (month.equals(monthStrList[i]) && (day >= 1 && day <= daysInMonth[i]) && (year >= 0 && year <= 2100)) {
                mIdx = i;
                return true;
            }
        }
        return false;
    }

    public boolean validDate(int day, int year) {
        return (day >= 1 && day <= 31) && (year >= 0 && year <= 2100);
    }

    public String genNumberFormat() {
        if (m_day <= 0 && m_monthInt <= 0)
            return "";
        return Integer.toString(this.m_monthInt) + "/" + Integer.toString(this.m_day) + "/" + Integer.toString(this.m_year);
    }

    public String genStringFormat() {
        if (this.m_monthStr == null)
            return "";
        return this.m_monthStr + " " + Integer.toString(this.m_day) + ", " + Integer.toString(this.m_year);
    }

    public String genDayFormat() {
        if (m_day <= 0)
            return "";
        return Integer.toString(m_day) + " " + Integer.toString(m_year);
    }

    public int getMIdx() {
        return mIdx;
    }
}
