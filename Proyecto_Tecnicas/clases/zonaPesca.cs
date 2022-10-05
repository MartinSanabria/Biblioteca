using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto_Tecnicas.clases
{
	internal class zonaPesca : puerto
	{
		private string codigo,ubicacion,coordenadas,especies;
		private DateTime uso;
		public zonaPesca() { }

		public zonaPesca(string codigo, string ubicacion, string coordenadas,
			string especies, DateTime uso)
		{
			this.codigo = codigo;
			this.ubicacion = ubicacion;
			this.coordenadas = coordenadas;
			this.especies = especies;
			this.uso = uso;
		}

		public zonaPesca(string pais, string nombre, string profundidad,
			string tipoGrua, string tipoAgua, double barcoCapacidad,
			string codigo,string ubicacion,string coordenadas,string especies
			,DateTime uso): 
			base(pais, nombre, profundidad, tipoGrua, tipoAgua,
				barcoCapacidad)
		{
			this.codigo = codigo;
			this.ubicacion = ubicacion;
			this.coordenadas = coordenadas;
			this.especies = especies;
			this.uso = uso;
		}

		//encapsulamiento a modificar
		public DateTime Uso { get => uso; set => uso = value; }
		public string Codigo { get => codigo; set => codigo = value; }
		public string Ubicacion { get => ubicacion; set => ubicacion = value; }
		public string Coordenadas { get => coordenadas; set => coordenadas = value; }
		public string Especies { get => especies; set => especies = value; }
	}
}
