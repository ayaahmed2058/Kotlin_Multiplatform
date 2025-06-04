import SwiftUI
import shared


struct ArticleItemView: View {
    var article: Article
    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            AsyncImage(url: URL(string: article.image))
            .resizable()
            .aspectRatio(contentMode: .fit)

            Text(article.title)
                .font(.title)
                .fontWeight(.bold)

            Text(article.description)

            Text(article.date)
                .frame(maxWidth: .infinity, alignment: .trailing)
                .foregroundStyle(.gray)
        }
        .padding(16)
    }
}
