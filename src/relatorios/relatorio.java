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
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import controle.CaixaDAO;
import entidades.Caixa;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class relatorio {

    public static void gerarRelatorio(CaixaDAO caixadao) { // criação do objeto documento
        Document document = new Document(PageSize.A4, 30, 20, 20, 30);
        OutputStream output;
        try {
            output = new FileOutputStream("PDF_LinhaCodigo.pdf");
            try {
                PdfWriter.getInstance(document, output);
                document.open(); // adicionando um parágrafo ao documento 
                document.add(new Paragraph("Relatório de BD - Fluxo de Caixa"));
                PdfPTable tabela = new PdfPTable(6);
                tabela.addCell("Código");
                tabela.addCell("Saldo Inicial");
                tabela.addCell("Saldo Aplicado");
                tabela.addCell("Saldo Final");
                tabela.addCell("Abertura");
                tabela.addCell("Fechamento");
                List<Caixa> caixas = caixadao.listarTodos();
                for (Caixa a : caixas) {
//                    tabela.addCell(""+a.getId());
//                    tabela.addCell(""+a.getSaldo_incial());
//                    tabela.addCell(""+a.getSaldo_aplicado());
//                    tabela.addCell(""+a.getSaldo_final());
//                    tabela.addCell(a.getData());
//                    tabela.addCell(a.getData_f());
                }
                document.add(tabela);
                document.close();
            } catch (DocumentException de) {
                System.err.println(de.getMessage());
                document.close();

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(relatorio.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.getMessage());

        }

    }
}
