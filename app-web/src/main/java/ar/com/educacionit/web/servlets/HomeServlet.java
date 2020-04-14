package ar.com.educacionit.web.servlets;
import java.io.IOException;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import ar.com.educacionit.app.domain.Producto;



@WebServlet(name = "HomeServlet", urlPatterns = "/api/home")
public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = 3429274211443195913L;
	
	// SE CREA EL METODO DOGET (CTRL + ESPACIO)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		
		// CONSULTAR A LA DB PARA OBTENER UN PRODUCTO
		System.out.println("HomeSrvlet req:  " + req);
		System.out.println("HomeSrvlet resp: " + resp);
		System.out.println("FUNCIONA OK");
		
		
		// consultar a la db para obtener un producto
				List<Producto> productos = findProductos();

				// guardar en la sesion los datos para mostrarlos luego en otro jsp
				req.getSession().setAttribute("productos", productos);

				// redireccionar a productos.jsp
				getServletContext().getRequestDispatcher("/productos.jsp").forward(req, resp);
	}
	
		
				// LISTA DE PRODUCTO
				public List<Producto> findProductos() {
					List<Producto> lista =  new ArrayList<Producto>();
					Producto producto = new Producto();
					producto.setId(1L);
					producto.setDescripcion("Pend driver");
					producto.setCodigo("abc");
					producto.setPrecio(175d);
					lista.add(producto);
					return lista;
					
					/*
					SessionFactory factory = HibernateUtils.getSessionFactory();
					
					Session session = factory.getCurrentSession();
					List<Producto> products = new ArrayList<Producto>();
					
					try {
						// All the action with DB via Hibernate
						// must be located in one transaction.
						// Start Transaction.
						session.getTransaction().begin();
						// Create an HQL statement, query the object.
						String sql = "Select e from " + Producto.class.getName() + " e ";
						javax.persistence.Query query = null;
						// Create Query 
						// Execute query.
						products = query.getResultList();
						// Commit data.
						session.getTransaction().commit();
					} catch (Exception e) {
						e.printStackTrace();
						// Rollback in case of an error occurred.
						session.getTransaction().rollback();
					} finally {
						session.close();
						// session.createQuery("");
					}
					return products;
					*/
				}
				
	}

