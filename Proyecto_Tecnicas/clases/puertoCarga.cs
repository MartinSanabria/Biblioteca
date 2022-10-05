using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto_Tecnicas.clases
{
	internal class puertoCarga : puerto
	{
		private int idPuerto;
		private string nombrePuerto, cdCantidad,estado;
		private DateTime fechaEmbargue;

		public puertoCarga() 
		
		{
			
		}

		public puertoCarga(string nombrePuerto, string cdCantidad, string Estado,
			DateTime fechaEmbarque)
		{
			this.nombrePuerto = nombrePuerto;
			this.cdCantidad = cdCantidad;
			this.Estado = Estado;
			this.fechaEmbargue = fechaEmbarque;
		}

		public puertoCarga(string pais, string nombre, string profundidad,
			string tipoGrua, string tipoAgua, double barcoCapacidad,
			string nombrePuerto, string cdCantidad, string Estado,
			DateTime fechaEmbarque) :
			base(pais,nombre,profundidad,tipoGrua,tipoAgua,
				barcoCapacidad)
		{
			this.nombrePuerto = nombrePuerto;
			this.cdCantidad = cdCantidad;
			this.Estado = Estado;
			this.fechaEmbargue = fechaEmbarque;
		}

		// encapsulamiento a modificar
		public string NombrePuerto { get => nombrePuerto; set => nombrePuerto = value; }
		public string CdCantidad { get => cdCantidad; set => cdCantidad = value; }
		public string Estado { get => estado; set => estado = value; }
		public DateTime FechaEmbargue { get => fechaEmbargue; set => fechaEmbargue = value; }
		public int IdPuerto { get => idPuerto; set => idPuerto = value; }
	}
}
