/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorios;

import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class relatorio {

    public static void gerarRelatorio() { // criação do objeto documento
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("C://PDF_LinhaCodigo.pdf"));
            document.open(); // adicionando um parágrafo ao documento 
            document.add(new Paragraph("Exemplo Geração de Arquivo PDF via iText - Java"));
        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        document.close();
    }
}
