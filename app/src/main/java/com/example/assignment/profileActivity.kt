package com.example.assignment // Or your actual package name

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight 
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profile", fontWeight = FontWeight.SemiBold, color = Color.White, modifier = Modifier.padding(start = 8.dp)) },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrow_back),
                            contentDescription = "Back",
                            tint = Color.White,
                            modifier = Modifier
                                .size(52.dp, 20.dp)
                                .padding(end = 8.dp).padding(start=8.dp)
                        )
                    }
                },
                actions = {
                    OutlinedButton(
                        onClick = {  },
                        modifier = Modifier.padding(end = 8.dp),
                        shape = RoundedCornerShape(50),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = Color.White
                        ),
                        border = BorderStroke(1.dp, Color.Gray)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_help_outline), // Your help icon
                            contentDescription = "Support",
                            modifier = Modifier.size(20.dp),
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Support", color = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF1A1A1A) 
                )
            )
        },
        containerColor = Color(0xFF121212)
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {
            item { Spacer(modifier = Modifier.height(24.dp)) }

            // Profile Header
            item {
                ProfileHeaderSection(
                    name = "Andaz Kumar",
                    memberSince = "member since Dec, 2020",
                    profileImageRes = R.drawable.profile_placeholder,
                    editIconResId = R.drawable.ic_edit 
                )
            }

            item { Spacer(modifier = Modifier.height(24.dp)) }

            
            item {
                CredGarageSection(garageIconResId = R.drawable.ic_garage) 
            }

            item { Spacer(modifier = Modifier.height(24.dp)) }

            // Info Items
            item {
                InfoItem(
                    iconResId = R.drawable.ic_credit_score, 
                    title = "credit score",
                    value = "757",
                    highlightText = "REFRESH AVAILABLE",
                    highlightColor = Color(0xFF30D5C8) 
                )
            }
            item { ListDivider() }
            item {
                InfoItem(
                    iconResId = R.drawable.ic_monetization, 
                    title = "lifetime cashback",
                    value = "₹3"
                )
            }
            item { ListDivider() }
            item {
                InfoItem(
                    iconResId = R.drawable.ic_account_balance, 
                    title = "bank balance",
                    value = "check"
                )
            }

            item { Spacer(modifier = Modifier.height(32.dp)) }

            // YOUR REWARDS & BENEFITS
            item {
                SectionHeader(title = "YOUR REWARDS & BENEFITS")
            }
            item { Spacer(modifier = Modifier.height(8.dp)) }
            item {
                RewardBenefitItem(
                    title = "cashback balance",
                    subtitle = "₹0"
                )
            }
            item { ListDivider() }
            item {
                RewardBenefitItem(
                    title = "coins",
                    subtitle = "26,46,583"
                )
            }
            item { ListDivider() }
            item {
                RewardBenefitItem(
                    title = "win upto Rs 1000",
                    subtitle = "refer and earn"
                )
            }

            item { Spacer(modifier = Modifier.height(32.dp)) }

            // TRANSACTIONS & SUPPORT
            item {
                SectionHeader(title = "TRANSACTIONS & SUPPORT")
            }
            item { Spacer(modifier = Modifier.height(8.dp)) }
            item {
                TransactionSupportItem(
                    title = "all transactions"
                )
            }
            item { Spacer(modifier = Modifier.height(24.dp)) } 
        }
    }
}

@Composable
fun ProfileHeaderSection(name: String, memberSince: String, profileImageRes: Int, editIconResId: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = profileImageRes),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(name, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Text(memberSince, fontSize = 14.sp, color = Color.Gray)
        }
        IconButton(onClick = { /* Handle edit profile */ }) {
            Icon(
                painter = painterResource(id = editIconResId),
                contentDescription = "Edit Profile",
                modifier = Modifier.size(63.dp, 59.dp), 
                tint = Color.Unspecified 
            )
        }
    }
}

@Composable
fun CredGarageSection(garageIconResId: Int) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF2A2A2A)), 
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = garageIconResId),
                contentDescription = "CRED Garage",
                tint = Color.LightGray, 
                modifier = Modifier.size(36.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    "get to know your vehicles, inside out",
                    fontSize = 14.sp,
                    color = Color.LightGray
                )
                Text(
                    "CRED garage",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            Icon(
                Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null,
                tint = Color.LightGray
            )
        }
    }
}

@Composable
fun InfoItem(
    iconResId: Int,
    title: String,
    value: String,
    highlightText: String? = null,
    highlightColor: Color = MaterialTheme.colorScheme.primary
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = iconResId),
            contentDescription = title,
            tint = Color.Unspecified, // Or Color.Unspecified
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(title.uppercase(), fontSize = 12.sp, color = Color.Gray, letterSpacing = 0.5.sp)
            if (highlightText != null) {
                Text(
                    highlightText,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = highlightColor
                )
            }
        }
        Text(value, fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null,
            tint = Color.Gray
        )
    }
}

@Composable
fun SectionHeader(title: String) {
    Text(
        title,
        fontSize = 13.sp,
        fontWeight = FontWeight.SemiBold,
        color = Color.Gray,
        modifier = Modifier.padding(vertical = 8.dp),
        letterSpacing = 0.8.sp
    )
}

@Composable
fun RewardBenefitItem(title: String, subtitle: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(title, fontSize = 16.sp, color = Color.White)
            Text(subtitle, fontSize = 14.sp, color = Color.Gray)
        }
        Icon(
            Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null,
            tint = Color.Gray
        )
    }
}

@Composable
fun TransactionSupportItem( title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Spacer(modifier = Modifier.width(16.dp))
        Text(title, fontSize = 16.sp, color = Color.White, modifier = Modifier.weight(1f))
        Icon(
            Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null,
            tint = Color.Gray
        )
    }
}

@Composable
fun ListDivider() {
    Divider(color = Color.DarkGray.copy(alpha = 0.5f), thickness = 0.5.dp)
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ProfileScreenDarkPreview() {
    MaterialTheme(colorScheme = darkColorScheme()) { 
        ProfileScreen()
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun ProfileScreenLightPreview() {
    MaterialTheme(colorScheme = lightColorScheme()) { 
        Surface(color = Color(0xFF121212)) {
            ProfileScreen()
        }
    }
}
