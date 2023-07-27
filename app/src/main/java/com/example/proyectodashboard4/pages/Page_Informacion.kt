package com.example.proyectodashboard4.pages

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectodashboard4.R

@Composable
fun Page_Informacion() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        androidx.compose.material3.Text(
            text = "Informacion",
            fontWeight = FontWeight.Bold,
            fontSize = 38.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(45.dp))
        Image(
            painter = painterResource(R.drawable.sena_informacion), // Reemplaza "carrusel_1" con el nombre de tu imagen en el directorio de recursos
            contentDescription = "Imagen Principal",
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))
        androidx.compose.material3.Text(
            text = "El Servicio Nacional de Aprendizaje (SENA) es una entidad pública de Colombia que ofrece formación técnica, tecnológica y de aprendizaje en diversos campos para promover el desarrollo y la capacitación de los ciudadanos en habilidades laborales. El SENA cuenta con centros de formación en diferentes regiones del país.\n" +
                    "\n" +
                    "Si estás interesado en obtener información actualizada sobre el \"SENA de Cundinamarca Centro de Biotecnología Agropecuaria\" o cualquier otro programa de formación específico, te recomendaría que visites el sitio web oficial del SENA o te comuniques directamente con ellos para obtener detalles precisos sobre su oferta educativa , ubicación y requisitos de inscripción.\n" +
                    "\n" +
                    "Puedes acceder al sitio web oficial del SENA de Colombia a través de la siguiente dirección: https://www.sena.edu.co/\n" +
                    "\n" +
                    "Allí encontrará información detallada sobre los programas de formación, finalización de los centros y cómo inscribirte en sus cursos y capacitaciones. Recuerda verificar la información pueden más reciente, ya que las cosas han cambiado desde la última actualización de mi conocimiento.",
            modifier = Modifier
                .width(800.dp)
                .padding(40.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(R.drawable.sena), // Reemplaza "carrusel_1" con el nombre de tu imagen en el directorio de recursos
            contentDescription = "Imagen Principal",
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))
        androidx.compose.material3.Text(
            text = "Para obtener información actualizada sobre el \"SENA de Cundinamarca Centro de Biotecnología Agropecuaria\" u otras consultas relacionadas con sus programas de formación, ubicación, inscripciones o cualquier otra información relevante, le recomendamos que realice lo siguiente:\n" +
                    "\n" +
                    "Sitio web oficial del SENA: Visita el sitio web oficial del SENA ( https://www.sena.edu.co/ ) y busca información sobre el centro de tu interés. Allí podrá encontrar detalles sobre los programas que ofrecen, requisitos, ubicación y cómo contactarlos directamente.\n" +
                    "\n" +
                    "Contacto directo: Comunícate con el SENA por teléfono o correo electrónico para obtener información específica sobre el centro de biotecnología agropecuaria en Cundinamarca. El personal del SENA podrá proporcionarte detalles actualizados y responder a tus preguntas.\n" +
                    "\n" +
                    "Redes sociales: Es posible que el SENA tenga presencia en redes sociales donde comparta información y actualizaciones sobre sus programas. Busca sus perfiles oficiales para mantenerse informado.\n" +
                    "\n" +
                    "Visitas presenciales: Si es posible, puede acudir personalmente a un centro del SENA cercano a cualquier información directa y aclarar la duda que pueda tener.\n" +
                    "\n" +
                    "Que el SENA es una institución que brinda oportunidades de formación y capacitación en diversas áreas, y puede haber diferentes centros con especialidades específicas en distintas regiones. Al consultar fuentes oficiales y comunicarte directamente con el SENA, podrás obtener información precisa y actualizada sobre el centro de biotecnología agropecuaria en Cundinamarca y otros programas que te puedan interesar.",
            modifier = Modifier
                .width(800.dp)
                .padding(40.dp)
        )
    }
}