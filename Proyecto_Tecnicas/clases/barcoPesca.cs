using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto_Tecnicas.clases
{
	internal class barcoPesca : barco
	{
		private string zonaPesca;

		public barcoPesca()
		{
			
		}

		public barcoPesca(string matricula, string bandera, string nombre, string tipoBarco, string calado, double tonelaje, DateTime fecha,
			string zonaPesca): 
			base (matricula,bandera,nombre,tipoBarco,calado,tonelaje,fecha)
		{
			this.ZonaPesca = zonaPesca;
		}

		public string ZonaPesca { get => zonaPesca; set => zonaPesca = value; }
	}
}
