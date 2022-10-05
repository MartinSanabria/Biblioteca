using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto_Tecnicas.clases
{
	internal class barco
	{
		private string matricula,bandera,nombre,tipoBarco,calado;
		private double tonelaje;
		private DateTime fecha;

		public barco() { }

		public barco(string matricula, string bandera, string nombre, string tipoBarco, string calado, double tonelaje, DateTime fecha)
		{
			Matricula = matricula;
			Bandera = bandera;
			Nombre = nombre;
			TipoBarco = tipoBarco;
			Calado = calado;
			Tonelaje = tonelaje;
			Fecha = fecha;
		}


		//encapsulamiento a modificar
		public string Matricula { get => matricula; set => matricula = value; }
		public string Bandera { get => bandera; set => bandera = value; }
		public string Nombre { get => nombre; set => nombre = value; }
		public string TipoBarco { get => tipoBarco; set => tipoBarco = value; }
		public string Calado { get => calado; set => calado = value; }
		public double Tonelaje { get => tonelaje; set => tonelaje = value; }
		public DateTime Fecha { get => fecha; set => fecha = value; }

	}
}
