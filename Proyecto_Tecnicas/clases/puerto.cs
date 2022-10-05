using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto_Tecnicas.clases
{
	internal class puerto
	{
		private string pais, nombre, profundidad, tipoGrua,tipoAgua;
		private double barcoCapacidad;


		public puerto() { }
		public puerto(string pais, string nombre, string profundidad, string tipoGrua, string tipoAgua, double barcoCapacidad)
		{
			Pais = pais;
			Nombre = nombre;
			Profundidad = profundidad;
			TipoGrua = tipoGrua;
			TipoAgua = tipoAgua;
			BarcoCapacidad = barcoCapacidad;
		}


		//encapsulamiento a modificar
		public string Pais { get => pais; set => pais = value; }
		public string Nombre { get => nombre; set => nombre = value; }
		public string Profundidad { get => profundidad; set => profundidad = value; }
		public string TipoGrua { get => tipoGrua; set => tipoGrua = value; }
		public string TipoAgua { get => tipoAgua; set => tipoAgua = value; }
		public double BarcoCapacidad { get => barcoCapacidad; set => barcoCapacidad = value; }
	}
}
