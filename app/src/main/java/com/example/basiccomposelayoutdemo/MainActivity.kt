@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.basiccomposelayoutdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basiccomposelayoutdemo.ui.theme.BasicComposeLayoutDemoTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //AppBottomNavigation()
            //val windowSizeClass= calculateWindowSizeClass(activity = this)
            //MyApp(windowSizeClass)
            //HomeScreen()
            //AppPortrait()
            //BasicComposeLayoutDemoTheme {
                // A surface container using the 'background' color from the theme
          //      Surface(
          //          modifier = Modifier.fillMaxSize(),
          //          color = MaterialTheme.colorScheme.background
           //     ) {
                    //Greeting("Android")
//                    FavoriteCollectionCard(
//                        modifier = Modifier,
//                        R.drawable.fc2_nature_meditations,
//                        R.string.fc2_nature_meditations
//                    )
                   // FavoriteCollectionsGrid()
                    //AlignYourBodyRow()
                    //HomeScreen()
                   // AppPortrait()
                   // AppLandscape()
           // constraintLayoutDemo()
           // testTwo()
           // AppPortrait()
            BottomNavigationExample()
            //dogScreen()

                }
            }
        }



private val alignYourBodyData = listOf(
    R.drawable.ab1_inversions to R.string.ab1_inversions,
    R.drawable.ab2_quick_yoga to R.string.ab2_quick_yoga,
    R.drawable.ab3_stretching to R.string.ab3_stretching,
    R.drawable.ab4_tabata to R.string.ab4_tabata,
    R.drawable.ab5_hiit to R.string.ab5_hiit,
    R.drawable.ab6_pre_natal_yoga to R.string.ab6_pre_natal_yoga
).map { DrawableStringPair(it.first, it.second) }

private val favoriteCollectionsData = listOf(
    R.drawable.fc1_short_mantras to R.string.fc1_short_mantras,
    R.drawable.fc2_nature_meditations to R.string.fc2_nature_meditations,
    R.drawable.fc3_stress_and_anxiety to R.string.fc3_stress_and_anxiety,
    R.drawable.fc4_self_massage to R.string.fc4_self_massage,
    R.drawable.fc5_overwhelmed to R.string.fc5_overwhelmed,
    R.drawable.fc6_nightly_wind_down to R.string.fc6_nightly_wind_down
).map { DrawableStringPair(it.first, it.second) }

private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)
@Composable
fun AlignYourBodyRow(modifier:Modifier=Modifier){
LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp),
contentPadding = PaddingValues(horizontal = 16.dp),
    modifier = Modifier
)    {
items(alignYourBodyData){item->
    AlignYourBodyElement(modifier = Modifier, drawable =item.drawable , item.text)
}
}
}
@Composable
fun searchBar(modifier: Modifier){
TextField(value = "",
    onValueChange = {},
    leadingIcon = {
                  Icon(imageVector = Icons.Default.Search, contentDescription = "")
    },
    placeholder = {
                  Text(stringResource(id = R.string.plceholder_search))
    },
    colors=TextFieldDefaults.textFieldColors(
unfocusedIndicatorColor = MaterialTheme.colorScheme.surface,
        focusedIndicatorColor = MaterialTheme.colorScheme.surface
    ),
    modifier = modifier
        .fillMaxWidth()
        .heightIn(min = 56.dp))
}
@Composable
fun AlignYourBodyElement(modifier: Modifier,
@DrawableRes drawable:Int,
@StringRes text:Int){
    Column(modifier = modifier,
    horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(drawable), contentDescription = "",
        modifier= Modifier
            .size(88.dp)
            .clip(CircleShape),
        contentScale = ContentScale.Crop)

        Text(text= stringResource(text),
        modifier=Modifier.paddingFromBaseline(top=24.dp,bottom=8.dp),
        style=MaterialTheme.typography.bodyMedium)
    }
}
@Composable
fun FavoriteCollectionsGrid(modifier:Modifier=Modifier
){
    LazyHorizontalGrid(rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier=modifier.height(168.dp) ){
        items(favoriteCollectionsData){
            item ->
            FavoriteCollectionCard(modifier = modifier, drawable =item.drawable , text = item.text)
        }
    }
}
@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () ->Unit){
    Column(modifier) {
        Text(text= stringResource(id = title),
             style=MaterialTheme.typography.titleMedium,
        modifier= Modifier
            .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
            .padding(horizontal = 16.dp))
        content()
    }
}
@Composable
fun HomeScreen(modifier:Modifier=Modifier){
  Column(modifier.verticalScroll(rememberScrollState()))  {
      Spacer(Modifier.height(16.dp))
      searchBar(Modifier.padding(horizontal = 16.dp))
      HomeSection(title = R.string.align_your_body) {
          AlignYourBodyRow()
      }
      HomeSection(title = R.string.favorite_collections) {
          FavoriteCollectionsGrid()
      }
      Spacer(Modifier.height(16.dp))
  }
}
val screens = listOf("Home", "Profile")

@Composable
fun AppBottomNavigation(modifier:Modifier=Modifier){
    //var selectedScreen by remember{ mutableStateOf(screens.first()) }
   /* when (selectedScreen) {
        "Home" -> HomeScreen()
        "Profile" -> profileScreen()

    }*/
 NavigationBar (
     containerColor=MaterialTheme.colorScheme.surfaceVariant,
     modifier=modifier
         ){
     NavigationBarItem(selected = true, onClick = { }, icon = {
         Icon(imageVector = Icons.Default.Home, contentDescription = "")
     },
     label = {
         Text(text= stringResource(id = R.string.bottom_navigation_home))
     })
     NavigationBarItem(selected = false, onClick = {  }, icon = {
         Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "")
     },
         label = {
             Text(text= stringResource(id = R.string.bottom_navigation_profile))
         })
 }
}
@Composable
fun AppNavigationRail(modifier:Modifier=Modifier){
    NavigationRail (
        containerColor=MaterialTheme.colorScheme.background,
        modifier=modifier.padding(start=8.dp,end=8.dp)
    ){
        NavigationRailItem(selected = true, onClick = {  }, icon = {
            Icon(imageVector = Icons.Default.Home, contentDescription = "")
        },
            label = {
                Text(text= stringResource(id = R.string.bottom_navigation_home))
            })
        Spacer(modifier = Modifier.height(8.dp))
        NavigationRailItem(selected = false, onClick = {  }, icon = {
            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "")
        },
            label = {
                Text(text= stringResource(id = R.string.bottom_navigation_profile))
            })
    }
}
@Composable
fun AppLandscape(){
    BasicComposeLayoutDemoTheme{
        Surface(color = MaterialTheme.colorScheme.background) {
            Row{
                AppNavigationRail()
                HomeScreen()
            }
        }

    }
}
@Composable
fun AppPortrait(){
    BasicComposeLayoutDemoTheme {
        Scaffold(bottomBar = { AppBottomNavigation()}) {
            paddingValues ->
            HomeScreen(Modifier.padding(paddingValues))
        }
    }
}
@Composable
fun FavoriteCollectionCard(modifier:Modifier,
@DrawableRes drawable: Int,
@StringRes text:Int){
    Surface(shape = MaterialTheme.shapes.medium, modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.width(255.dp)) {
          Image(painter = painterResource(drawable),
          contentDescription = null, contentScale = ContentScale.Crop, modifier = Modifier.size(80.dp))
            Text(text= stringResource(text),
            style=MaterialTheme.typography.titleMedium,
            modifier=Modifier.padding(horizontal = 16.dp))
        }
    }
}
@Composable
fun MyApp(windowSize:WindowSizeClass){
when(windowSize.widthSizeClass){
    WindowWidthSizeClass.Compact->{
        AppPortrait()}
    WindowWidthSizeClass.Expanded->{
        AppLandscape()}
}
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BasicComposeLayoutDemoTheme {
        //FavoriteCollectionCard(modifier=Modifier,R.drawable.fc2_nature_meditations,R.string.fc2_nature_meditations)
        //Greeting("Android")
       // searchBar(modifier = Modifier)
       // AlignYourBodyElement(modifier = Modifier,R.drawable.ab1_inversions,R.string.ab1_inversions)
        //FavoriteCollectionsGrid()
       // HomeScreen()
        //constraintLayoutDemo()
        //testTwo()
    }
}