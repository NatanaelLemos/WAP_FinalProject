package web.viewmodels;

import java.util.List;

public class DataTableResult {
    private int draw;
    private int recordsTotal;
    private int recordsFiltered;
    private List data;
    private int totalDisplayRecords;
    private int totalRecords;

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public int getTotalDisplayRecords() {
        return totalDisplayRecords;
    }

    public void setTotalDisplayRecords(int totalDisplayRecords) {
        this.totalDisplayRecords = totalDisplayRecords;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public static DataTableResult get(List data, int total, int page){
        DataTableResult result = new DataTableResult();

        result.data = data;
        result.recordsTotal = total;
        result.recordsFiltered = total;
        result.totalRecords = total;
        result.totalDisplayRecords = page;

        result.draw = ++drawInstance;
        return result;
    }

    private static int drawInstance = 0;
}
