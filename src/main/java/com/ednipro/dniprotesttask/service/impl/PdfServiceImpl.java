package com.ednipro.dniprotesttask.service.impl;

import com.ednipro.dniprotesttask.model.CellModel;
import com.ednipro.dniprotesttask.model.RowModel;
import com.ednipro.dniprotesttask.model.SheetModel;
import com.ednipro.dniprotesttask.model.WorkbookModel;
import com.ednipro.dniprotesttask.service.PdfService;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PdfServiceImpl implements PdfService {
    public String makePdfFromWorkbook(WorkbookModel workbookModel) {
        Document document = null;
        String fileName = workbookModel.getName().substring(0,
                workbookModel.getName().indexOf(".")) + ".pdf";
        try {
            document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("uploads/" + fileName));
            document.open();
            document.add(new Chunk());
            List<SheetModel> sheetModels = workbookModel.getSheetModels();
            for (SheetModel sheet : sheetModels) {
                document.add(createPdfTableFromModel(sheet));
                document.newPage();
            }
        } catch (DocumentException | FileNotFoundException e) {
            throw new RuntimeException("Can't create pdf file", e);
        } finally {
            if (document != null) {
                document.close();
            }
        }
        return fileName;
    }

    private PdfPTable createPdfTableFromModel(SheetModel sheet) {
        int sizeOfTable = sheet.getRowModels()
                .get(1).getCellModels().size();
        PdfPTable table = new PdfPTable(sizeOfTable);
        for (RowModel row : sheet.getRowModels()) {
            for (CellModel cell : row.getCellModels()) {
                table.addCell(cell.getValue());
            }
            table.completeRow();
        }
        return table;
    }
}
