package utilidades;

import java.io.File;
import java.io.FileInputStream;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class DatosXML {

	public static Object[][] leerXML(String ruta, String tagDatos) throws Exception {
		// Creo es tipo de archivo con clase estandar para manejo de archivos.
		File file = new File(ruta);
		
		FileInputStream inputStream = new FileInputStream(file);

		
		// Creo el objeto para manejo de archivos XML
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		// Creo un objeto DocumentBuilder a traves del objeto DocumentBuilderFactory
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		// Creo un objeto Documento a traves del objeto Document Builder para que parsee el archivo XML de la ruta especificada
		Document document = builder.parse(file);
		
		document.getDocumentElement().normalize();
		
		
		//Tomo todas los Tags correspondientes al Tag enviado en metodo que correspondera a la agrupado de una prueba.
		NodeList Nodo = document.getElementsByTagName(tagDatos);
		
		//Tomo el nodo actual
		Node nodo = Nodo.item(0);
		//Transformo el nodo en elemento
		Element element = (Element) nodo;
		
		//Creo variables para asignar corresponder cantidad de pruebas=filas y cantidad de datos=columnas
		int fila;
		int col;
		//Asigno la cantidad de Tags de cada prueba al valor de columnas
		col = element.getElementsByTagName("*").getLength();
		Node n;
		//Asigno la cantidad de pruebas.
		fila = Nodo.getLength();
		
		//Creo mi objeto de tipo Object para devolver posteriormente con la matriz completa. La dimension la determinara las variables fila y col
		Object matrizDatos[][] = new Object[fila][col];
		
		System.out.println("Leyendo archivo XML.." + "\n");
		System.out.println("Ruta de arhivo: " + ruta);
		System.out.println("Nombre de Tag de prueba: " + tagDatos);
		System.out.println("Cantidad de Filas con datos: " + fila);
		System.out.println("Cantidad de Columnas con datos: " + col);
		System.out.println("Elemento raiz:" + document.getDocumentElement().getNodeName());
		System.out.println("--------------------------------------------------------");
		
		//Recorro los datos de los Tags a traves los nodos.
		for (int i = 0; i < Nodo.getLength(); i++) {
			nodo = Nodo.item(i);
			System.out.println("Elemento:" + nodo.getNodeName());
			if (nodo.getNodeType() == Node.ELEMENT_NODE) {
				element = (Element) nodo;
				NodeList nl = element.getElementsByTagName("*");
				for (int j = 0; j < nl.getLength(); j++) {
					n = nl.item(j);
					System.out.println(n.getNodeName() + ":"
							+ element.getElementsByTagName(n.getNodeName()).item(0).getTextContent());
					matrizDatos[i][j] = element.getElementsByTagName(n.getNodeName()).item(0).getTextContent();

				}
			}
			System.out.println("--------------------------------------------------------");
		}
		//Cierro el archivo
		inputStream.close();
		/*
		 * Retorno el valor de objeto Object con datos asignados. Cada vez que se
		 * ejecute el metodo DatosXML.leerExcel() este devolvera este Object[][] dinamico
		 * completo e inicializado segun dimensiones basado en datos.
		 */
		return matrizDatos;
	}
}