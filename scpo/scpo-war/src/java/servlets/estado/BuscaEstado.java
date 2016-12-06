package servlets.estado;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import util.OkClient;

/**
 *
 * @author erick.araujo
 */
@WebServlet(name = "buscarEstado", urlPatterns = {"/estado/id"})
public class BuscaEstado extends HttpServlet {

    @Inject
    private OkClient okClient;

    @Inject
    private Logger log;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String t = req.getParameter("idEstado");
        log.info("id enviado: " +  t);
    }
}
