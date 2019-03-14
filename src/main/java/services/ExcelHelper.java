package services;

import models.ItemIt;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public  class ExcelHelper {



   private MultipartFile file;



    public ExcelHelper(MultipartFile reapExcelDataFile) {
        this.file = reapExcelDataFile;
    }

    public List<ItemIt> processExcel() throws IOException, InvalidFormatException {


        List<ItemIt> itemIts = new ArrayList<>();

        Workbook workbook = WorkbookFactory.create(file.getInputStream());
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");



        Iterator<Sheet> sheetIterator = workbook.sheetIterator();
        System.out.println("Retrieving Sheets using Iterator");
        while (sheetIterator.hasNext()) {
            Sheet sheet = sheetIterator.next();
            System.out.println("=> " + sheet.getSheetName());
        }


        Sheet sheet = workbook.getSheetAt(0);

        System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
        Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            try {


                ItemIt itemIt = new ItemIt();


                if (row.getCell(0) == null){
                    itemIt.setName("Нет записи");
                }else itemIt.setName(row.getCell(0).getStringCellValue());

                if (row.getCell(1) == null){
                    itemIt.setSrokEkspluatacii(0);
                }else itemIt.setSrokEkspluatacii((int) row.getCell(1).getNumericCellValue());

                if (row.getCell(2) == null){
                    itemIt.setVvodEkspluatacii(new Date());
                }else itemIt.setVvodEkspluatacii(row.getCell(2).getDateCellValue());

                if (row.getCell(3) == null){
                    itemIt.setInventoryNumber("нет записи");
                }else itemIt.setInventoryNumber(row.getCell(3).getStringCellValue());

                if (row.getCell(4) == null){
                    itemIt.setSerialNumber("нет записи");
                }else itemIt.setSerialNumber(row.getCell(4).getStringCellValue());

                if (row.getCell(5) == null){
                    itemIt.setDislocation("Нет записи");
                }else itemIt.setDislocation(row.getCell(5).getStringCellValue());


                itemIts.add(itemIt);


            }catch (Exception e){
                System.out.println(e.getMessage());

                e.printStackTrace();
            }


        }

return itemIts;
    }

    /**
    private static void printCellValue(Cell cell) {
        switch (cell.getCellTypeEnum()) {
            case BOOLEAN:
                System.out.print(cell.getBooleanCellValue());
                break;
            case STRING:
                System.out.print(cell.getRichStringCellValue().getString());
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    System.out.print(cell.getDateCellValue());
                } else {
                    System.out.print(cell.getNumericCellValue());
                }
                break;
            case FORMULA:
                System.out.print(cell.getCellFormula());
                break;
            case BLANK:
                System.out.print("");
                break;
            default:
                System.out.print("");
        }

        System.out.print("\t");
    }

    {
        try {


            FileInputStream file = new FileInputStream(new File("D:\\1.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next();
            while(rowIterator.hasNext())
            {
                Row row = rowIterator.next();
                //For each row, iterate through each columns
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();
                    switch(cell.getCellType())
                    {
                        case Cell.CELL_TYPE_BOOLEAN:
                            System.out.println("boolean===>>>"+cell.getBooleanCellValue() + "\t");
// write hibernate lines here to store it in your domain
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.println("numeric===>>>"+cell.getNumericCellValue() + "\t");
// write hibernate lines here to store it in your domain
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.println("String===>>>"+cell.getStringCellValue() + "\t");
// write hibernate lines here to store it in your domain
                            break;
                    }
                }
                System.out.println("");
            }
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



*/
}
