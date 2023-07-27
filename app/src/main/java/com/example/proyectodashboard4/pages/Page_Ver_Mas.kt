package com.example.proyectodashboard4.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectodashboard4.R

@Composable
fun Page_Ver_Mas() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState()),

        ) {
        androidx.compose.material3.Text(
            text = "Noticias",
            fontWeight = FontWeight.Bold,
            fontSize = 38.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(45.dp))
        Image(
            painter = painterResource(R.drawable.sena), // Reemplaza "carrusel_1" con el nombre de tu imagen en el directorio de recursos
            contentDescription = "Imagen Principal",
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))
        androidx.compose.material3.Text(
            text = "El Servicio Nacional de Aprendizaje (SENA) cumple 66 años de existencia en este año, y es momento de reflexionar sobre su legado y su impacto en la sociedad colombiana. Desde su creación en 1957, el SENA se ha convertido en una institución fundamental para el desarrollo del país, promoviendo la formación técnica y profesional de miles de colombianos y contribuyendo a la construcción de un futuro más próspero y equitativo.\n" +
                    "\n" +
                    "A lo largo de su historia, el SENA ha desempeñado un papel crucial en la transformación de la fuerza laboral colombiana. A través de su amplia oferta educativa, que abarca desde programas de formación técnica hasta cursos de capacitación especializada, el SENA ha brindado a los jóvenes y adultos colombianos las herramientas necesarias para insertarse en el mercado laboral y mejorar sus oportunidades de empleo.\n" +
                    "\n" +
                    "Uno de los aspectos más destacados del SENA es su enfoque práctico y orientado al mundo laboral. Los estudiantes tienen la oportunidad de adquirir conocimientos teóricos, pero también de aplicarlos en entornos reales de trabajo. Esto les brinda una ventaja competitiva al momento de buscar empleo, ya que cuentan con experiencia práctica que los empleadores valoran.\n" +
                    "\n" +
                    "Además de su enfoque en la formación técnica, el SENA también ha fomentado el emprendimiento y la innovación. A través de programas y proyectos que promueven el espíritu empresarial, el SENA ha impulsado el surgimiento de nuevos negocios y ha apoyado a los emprendedores colombianos en su camino hacia el éxito.\n" +
                    "\n" +
                    "El compromiso del SENA con la inclusión social también ha sido notable a lo largo de los años. La institución ha trabajado arduamente para brindar oportunidades educativas a aquellos sectores de la población que tradicionalmente han estado marginados. Mediante programas de formación dirigidos a comunidades rurales, personas con discapacidades y grupos en situación de vulnerabilidad, el SENA ha contribuido a reducir las brechas sociales y promover la equidad.",

            modifier = Modifier
                .width(800.dp)
                .padding(40.dp)
        )
    }
}
