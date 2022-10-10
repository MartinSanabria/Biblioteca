using System;
using Npgsql;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Proyecto_Tecnicas.clases
{
    public partial class ConusltaBarcos : Form
    {
        private conec conec;
        puerto puerto = new puerto();
        public ConusltaBarcos()
        {
            InitializeComponent();
            dataGridView1.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;
            conec = new clases.conec();
            this.cPuertos();
            this.Fecha();
        }

        

        private void Button1_Click_1(object sender, EventArgs e)
        {
        
            llenar();
        }

        public void cPuertos()
        {
            NpgsqlCommand cmd = new NpgsqlCommand("select nombre_puerto from puerto;",
               conec.establecerConexion());
            var Valores = new List<String>();

            NpgsqlDataReader consulta = cmd.ExecuteReader();

            while (consulta.Read())
            {
                // Console.Write("{0}\n", dr[1]);
                Valores.Add(consulta.GetString(0));
            }
            cbPuertos.DataSource=Valores;
            cbPuertos.DropDownStyle = ComboBoxStyle.DropDownList;
        }

        public void Fecha()
        {
            NpgsqlCommand cmd = new NpgsqlCommand("select distinct fecha_atraco from barco;",
              conec.establecerConexion());
            var Valores = new List<DateTime>();

            NpgsqlDataReader consulta = cmd.ExecuteReader();

            while (consulta.Read())
            {
                // Console.Write("{0}\n", dr[1]);
                Valores.Add((DateTime)consulta[0]);
            }
            cbFechas.DataSource = Valores;
            cbFechas.DropDownStyle = ComboBoxStyle.DropDownList;
        }

        void llenar()
        {


            NpgsqlCommand cmd = new NpgsqlCommand("select bc.matricula,bc.bandera,bc.nombre_barco,bc.calado,bc.tonelaje," +
                "tp.tipo_barco,bc.fecha_atraco from barco bc " +
                "inner join tipoBarco tp on tp.id_barco = bc.tipoBarco;",
                conec.establecerConexion());
            this.dataGridView1.ReadOnly=true;

            NpgsqlDataReader consulta = cmd.ExecuteReader();

            while (consulta.Read())
            {
               // Console.Write("{0}\n", dr[1]);
                dataGridView1.Rows.Add(consulta[0], consulta[1], consulta[2],
                    consulta[3], consulta[4], consulta[5], consulta[6]);
            }
            



            conec.establecerConexion().Close();
        }
        void limpiar()
        {

            dataGridView1.Rows.Clear();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            limpiar();
        }

		private void button3_Click(object sender, EventArgs e)
		{
            String nombre = "";
            nombre = Convert.ToString(cbPuertos.SelectedItem);
            int id_puerto=0;
            NpgsqlCommand cmd = new NpgsqlCommand("select id_puerto from puerto "+
                    "where nombre_puerto = @nombrePuerto;",
                conec.establecerConexion());
            this.dataGridView1.ReadOnly = true;
            cmd.Parameters.AddWithValue("@nombrePuerto",nombre);
            id_puerto = Convert.ToInt32(cmd.ExecuteScalar());

 
            if (id_puerto > 0)
            {
                NpgsqlCommand cmd1 = new NpgsqlCommand("select bc.matricula,bc.bandera,bc.nombre_barco,bc.calado," +
					"bc.tonelaje,tp.tipo_barco,bc.fecha_atraco from barco bc "+
                    "inner join tipoBarco tp on tp.id_barco = bc.tipoBarco "+
                    "where id_puerto = @idPuerto;" ,
                conec.establecerConexion());
                cmd1.Parameters.AddWithValue("@idPuerto",id_puerto);
                this.dataGridView1.ReadOnly = true;
                limpiar();
                NpgsqlDataReader consulta1 = cmd1.ExecuteReader();
                while (consulta1.Read())
                {
                    // Console.Write("{0}\n", dr[1]);
                    dataGridView1.Rows.Add(consulta1[0], consulta1[1], consulta1[2],
                        consulta1[3], consulta1[4], consulta1[5], consulta1[6]);
                }

            }
        }

		private void cbPuertos_SelectedIndexChanged(object sender, EventArgs e)
		{
            
        }

		private void button4_Click(object sender, EventArgs e)
		{
           
        }
	}
}
