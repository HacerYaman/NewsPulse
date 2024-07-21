package com.example.newspulse.presentation.component

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.newspulse.R
import com.example.newspulse.presentation.Dimens.MediumPadding1
import com.example.newspulse.presentation.Dimens.MediumPadding2
import com.example.newspulse.presentation.onboarding.Page
import com.example.newspulse.presentation.onboarding.pages
import com.example.newspulse.ui.theme.NewsPulseTheme


@Composable
fun OnboardingPage(
    page: Page, modifier: Modifier = Modifier
) {

    Column(modifier = modifier) {
        Image(
            modifier = Modifier
                .fillMaxHeight(fraction = 0.6f)
                .fillMaxWidth(),
            painter = painterResource(id = page.image),
            contentScale = ContentScale.Crop,
            contentDescription = null,

            )
        Spacer(modifier = Modifier.height(MediumPadding1))

        Text(
            text = page.title,
            modifier = Modifier.padding(horizontal = MediumPadding2),
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color= colorResource(id = R.color.display_small)
        )

        Text(
            text = page.description,
            modifier = Modifier.padding(horizontal = MediumPadding2),
            style = MaterialTheme.typography.bodyMedium,
            color= colorResource(id = R.color.text_medium)
        )
    }

}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun OnboardingPagePreview(){
    NewsPulseTheme {
        OnboardingPage(page = pages[0])
    }
}