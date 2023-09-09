package com.example.basiccomposelayoutdemo

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Preview
@Composable
fun dogScreen(modifier:Modifier=Modifier){
    val borderWidth=1.5.dp
    val ringBrush= remember {
        Brush.sweepGradient(listOf(Color(0XFFC913B9),Color(0xFFF9373F),Color(0xFFFECD00)))
    }
 ConstraintLayout (
     modifier= modifier
         .fillMaxWidth()
         .background(Color.White)
         .padding(vertical = 7.dp)
         ){
     val(imgAvatar,imgMore,textUserNameTop,imgPost,imgTags,imgLike,imgShare,imgBookmark,
     textLikes,textUserNameBottom,imgComment,textViewComments)=createRefs()
     Image(painter = painterResource(id = R.drawable.avatar), contentDescription =""
     ,modifier= modifier
             .constrainAs(imgAvatar) {
                 start.linkTo(parent.start, 14.dp)
                 top.linkTo(parent.top)
             }
             .size(35.dp)
             .border(
                 border = BorderStroke(borderWidth, ringBrush),
                 shape = CircleShape
             )
             .padding(3.dp)
             .clip(CircleShape))
     Column(modifier = modifier.constrainAs(textUserNameTop) {
         start.linkTo(imgAvatar.end,7.dp)
         top.linkTo(imgAvatar.top)
         bottom.linkTo(imgAvatar.bottom)
     }) {

         Text(text="Sweetie",style= TextStyle(color=Color.Magenta, fontWeight = FontWeight.Bold, fontSize = 12.sp))
         Text(text="Sponsored by Thiri",style= TextStyle(color=Color.Black, fontWeight = FontWeight.SemiBold, fontSize = 11.sp))
     }
     Image(painter = painterResource(id = R.drawable.ic_more), contentDescription ="more",
     modifier=modifier.constrainAs(imgMore){
         end.linkTo(parent.end,14.dp)
         top.linkTo(imgAvatar.top)
         bottom.linkTo(imgAvatar.bottom)
     })
     Image(painter = painterResource(id = R.drawable.post_image), contentDescription = "",
     modifier= modifier
         .constrainAs(imgPost) {
             start.linkTo(parent.start, 5.dp)
             top.linkTo(imgAvatar.bottom, 7.dp)
             end.linkTo(parent.end)
             width = Dimension.fillToConstraints
         }
         .fillMaxWidth()
         .height(400.dp),
     contentScale = ContentScale.Crop)
     Image(painter = painterResource(id = R.drawable.ic_tags), contentDescription ="",
     modifier=modifier.constrainAs(imgTags){
         start.linkTo(imgPost.start,7.dp)
         bottom.linkTo(imgPost.bottom,7.dp)
     })
     Image(painter = painterResource(id = R.drawable.ic_liked), contentDescription ="",
         modifier=modifier.constrainAs(imgLike){
             top.linkTo(imgPost.bottom,7.dp)
             start.linkTo(imgAvatar.start)
         }.width(24.dp).height(24.dp))
     Image(painter = painterResource(id = R.drawable.ic_comment), contentDescription ="",
         modifier=modifier.constrainAs(imgComment){
             top.linkTo(imgLike.top)
             start.linkTo(imgLike.end,10.dp)
         }.width(24.dp).height(24.dp))
     Image(painter = painterResource(id = R.drawable.ic_share), contentDescription ="",
         modifier=modifier.constrainAs(imgShare){
             top.linkTo(imgComment.top)
             start.linkTo(imgComment.end,10.dp)
         }.width(24.dp).height(24.dp))
     Image(painter = painterResource(id = R.drawable.ic_bookmark), contentDescription ="",
         modifier=modifier.constrainAs(imgBookmark){
             top.linkTo(imgLike.top)
             end.linkTo(parent.end,14.dp)
         }.width(24.dp).height(24.dp))
     Text(text="150 Likes",style= TextStyle(
         color=Color.Black,
         fontWeight = FontWeight.SemiBold,
         fontSize = 12.sp
     ),
         modifier=modifier.constrainAs(textLikes){
             start.linkTo(imgLike.start)
             top.linkTo(imgLike.bottom,7.dp)
         }
     )
     Text(text="My dog is not a pet; my dog is family. Home is where my dog is. No matter how many years we get with our dogs, it's never enough. Life is better with a dog.A house is not a home without a dog.",
         style= TextStyle(
         color=Color.Black,
         fontWeight = FontWeight.SemiBold,
         fontSize = 14.sp
     ),
         modifier=modifier.constrainAs(textUserNameBottom){
             start.linkTo(textLikes.start)
             top.linkTo(textLikes.bottom,7.dp)
             end.linkTo(parent.end,14.dp)
             width=Dimension.fillToConstraints
         }
     )
     Text(text="View all 15 comments",style= TextStyle(
         color=Color.Gray,
         fontWeight = FontWeight.Normal,
         fontSize = 14.sp
     ),
         modifier=modifier.constrainAs(textViewComments){
             start.linkTo(textUserNameBottom.start)
             top.linkTo(textUserNameBottom.bottom,7.dp)
         }
     )

 }
}
@Composable
fun testOne(){
 ConstraintLayout(modifier=Modifier.fillMaxSize()) {
     val (box1,box2,box3)=createRefs()
     Box(modifier = Modifier
         .size(150.dp)
         .background(Color.Red)
         .constrainAs(box1) {
             top.linkTo(parent.top, 16.dp)
             start.linkTo(parent.start, 20.dp)
         }){

     }
     Box(modifier = Modifier
         .size(100.dp)
         .background(Color.Yellow)
         .constrainAs(box2) {
             top.linkTo(box1.bottom, 20.dp)
             start.linkTo(parent.start, 20.dp)
         }){

     }
     Box(modifier = Modifier
         .size(50.dp)
         .background(Color.Green)
         .constrainAs(box3) {
             top.linkTo(box2.bottom, 20.dp)
             start.linkTo(parent.start, 20.dp)
         }){

     }
 }
}
