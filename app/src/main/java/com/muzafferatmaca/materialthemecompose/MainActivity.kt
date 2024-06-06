package com.muzafferatmaca.materialthemecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.muzafferatmaca.materialthemecompose.data.DataSource
import com.muzafferatmaca.materialthemecompose.domain.entity.Dog
import com.muzafferatmaca.materialthemecompose.ui.theme.MaterialThemeComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialThemeComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    DogsApp()
                }
            }
        }
    }
}

@Composable
fun DogsApp() {
    Scaffold {
        LazyColumn(
            contentPadding = it
        ) {
            items(DataSource().loadDogs()) { dog ->
                DogItem(
                    dog = dog,
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))
                )
            }
        }
    }
}

@Composable
fun DogItem(dog: Dog,modifier: Modifier) {
    Card (modifier = modifier
        .clip(MaterialTheme.shapes.medium)){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_small))
        ) {
            DogIcon(dogIcon = dog.imageResourceId)
            DogInformation(dogName = dog.name, dogAge = dog.age)
        }
    }
}

@Composable
fun DogIcon(
    modifier: Modifier = Modifier,
    @DrawableRes dogIcon: Int
) {
    Image(
        painter = painterResource(id = dogIcon),
        contentDescription = null,
        modifier = modifier
            .size(dimensionResource(id = R.dimen.image_size))
            .padding(dimensionResource(id = R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun DogInformation(
    modifier: Modifier = Modifier,
    @StringRes dogName: Int,
    dogAge: Int
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(id = dogName),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_small))
        )
        Text(
            text = stringResource(R.string.years_old, dogAge),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DogIconPreview() {

}


