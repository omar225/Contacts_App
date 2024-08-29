package com.example.contactsapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contactsapp.data.DataSource
import com.example.contactsapp.model.ContactInfo
import com.example.contactsapp.ui.theme.ContactsAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContactsAppTheme {
                val context = LocalContext.current
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    text = "Contacts App",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 24.sp
                                )
                            },
                            actions = {
                                IconButton(onClick = {
                                    val phoneNumber = Uri.parse("tel: +201016840078")
                                    val i = Intent(Intent.ACTION_DIAL, phoneNumber)
                                    context.startActivity(i)
                                }
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_home),
                                        contentDescription = "Home"
                                    )

                                }
                            }
                        )
                    }
                ) { innerPadding ->
                            Box ( modifier = Modifier.padding(innerPadding)){
                        ContactsApp(DataSource().getContactsList())
                    }
                }
            }
        }
    }
}

@Composable
fun ContactsApp(contacts: List<ContactInfo>, modifier: Modifier = Modifier) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = modifier
        ) {
            items(contacts.size) {
                ContactListItem(contact = contacts[it])
            }
        }
    }



@Preview(showSystemUi = true)
@Composable
private fun ContactsAppPreview() {
    ContactsApp(contacts = DataSource().getContactsList())
}

@Composable
fun ContactListItem(contact: ContactInfo, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val phoneNumber = stringResource(id = contact.number)
    Card(
        onClick = {
            val i = Intent(Intent.ACTION_DIAL, Uri.parse("tel: $phoneNumber"))
            context.startActivity(i)
        },

        colors = CardDefaults.cardColors(containerColor = Color.LightGray),
        shape = RectangleShape,
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = contact.picture),
                contentDescription = "Picture of contact",
                modifier = modifier
                    .fillMaxSize()
                    .size(120.dp)
                    .align(alignment = Alignment.CenterHorizontally)

            )

            Text(
                text = stringResource(id = contact.name),
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(top = 4.dp)
            )
            SelectionContainer {
                Text(
                    text = stringResource(id = contact.number),
                    color = Color.DarkGray,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(top = 4.dp)
                )
            }
        }
        
    }

}
