using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace MyTestSoap
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            JavaSoapService.StudentDetailsPortClient javaSoap = new JavaSoapService.StudentDetailsPortClient();
            JavaSoapService.StudentDetailsRequest myRequest = new JavaSoapService.StudentDetailsRequest();
            myRequest.name = "Luke";
            JavaSoapService.StudentDetailsResponse myResponse = javaSoap.StudentDetails(myRequest);

            MessageBox.Show(myResponse.Student.address);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            MyDotNetSoap.Service1Client myNetSoap = new MyDotNetSoap.Service1Client();
            string myReturn = myNetSoap.HelloWorld("Luke");
            MessageBox.Show(myReturn);

        }
    }
}
