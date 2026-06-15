package com.example.dailyaffirmationfirestore.ui.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.viewmodel.ViewModelAffirmation

@Composable
fun DisplayAffirmations(
    viewModel: ViewModelAffirmation = viewModel()
) {

    var showEditDialog by remember {
        mutableStateOf(false)
    }

    var selectedId by remember {
        mutableStateOf("")
    }

    var updatedText by remember {
        mutableStateOf("")
    }

    var affirmationText by remember {
        mutableStateOf("")
    }

    val affirmations = viewModel.affirmations

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDF7FB))
            .padding(top = 32.dp, start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Daily Affirmations",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFE78CB6)
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = affirmationText,
            onValueChange = {
                affirmationText = it
            },
            placeholder = {
                Text("Write your affirmations...")
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFE78CB6),
                unfocusedBorderColor = Color.Gray
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (affirmationText.isNotBlank()) {
                    viewModel.addAffirmation(affirmationText)
                    affirmationText = ""
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFE78CB6)
            ),
            shape = RoundedCornerShape(50)
        ) {
            Text("Save",
                fontSize = 18.sp,
                )
        }

        Spacer(modifier = Modifier.height(24.dp))

        if (affirmations.isEmpty()) {

            Text(
                text = "No affirmations yet 🌸",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                color = Color.Gray,
                fontSize = 18.sp
            )

        } else {

            LazyColumn {

                items(affirmations) { affirmation ->

                    AffirmationItem(
                        id = affirmation.first,
                        text = affirmation.second,
                        onDelete = {
                            viewModel.deleteAffirmation(affirmation.first)
                        },
                        onEdit = {
                            selectedId = affirmation.first
                            updatedText = affirmation.second
                            showEditDialog = true
                        }
                    )

                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
    if (showEditDialog) {

        AlertDialog(
            onDismissRequest = {
                showEditDialog = false
            },

            title = {
                Text("Edit Affirmation")
            },

            text = {

                OutlinedTextField(
                    value = updatedText,
                    onValueChange = {
                        updatedText = it
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            },

            confirmButton = {

                TextButton(
                    onClick = {

                        if (updatedText.isNotBlank()) {

                            viewModel.updateAffirmation(
                                selectedId,
                                updatedText
                            )

                            showEditDialog = false
                        }
                    }
                ) {
                    Text("Update")
                }
            },

            dismissButton = {

                TextButton(
                    onClick = {
                        showEditDialog = false
                    }
                ) {
                    Text("Cancel")
                }
            }
        )
    }
}

@Composable
fun AffirmationItem(
    id: String,
    text: String,
    onDelete: () -> Unit,
    onEdit: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(12.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = text,
                modifier = Modifier.weight(1f),
                fontSize = 18.sp
            )

            IconButton(
                onClick = onEdit
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit",
                    tint = Color(0xFFE78CB6)
                )
            }

            IconButton(
                onClick = onDelete
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete",
                    tint = Color(0xFFE78CB6)
                )
            }
        }
    }
}