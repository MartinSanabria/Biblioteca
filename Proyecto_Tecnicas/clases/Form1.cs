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
    public partial class Form1 : Form
    {
        private CurrencyManager currencyManager;

        public Form1()
        {
            InitializeComponent();
            dataGridView1.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;   
        }

        

        private void Button1_Click_1(object sender, EventArgs e)
        {
        
            llenar();
        }

        void llenar()
        {
            clases.conec conec = new clases.conec();
            conec.establecerConexion();


            NpgsqlCommand cmd = new NpgsqlCommand("select * from puerto", conec.establecerConexion());


            NpgsqlDataReader dr = cmd.ExecuteReader();
            dataGridView1.AutoGenerateColumns = true;


            while (dr.Read())
            {
               // Console.Write("{0}\n", dr[1]);
                dataGridView1.Rows.Add(dr[0], dr[1], dr[2], dr[3], dr[4], dr[5], dr[6], dr[7]);
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
    }
}
