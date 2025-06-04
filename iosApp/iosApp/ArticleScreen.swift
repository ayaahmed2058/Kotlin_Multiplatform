import SwiftUI
import shared

struct ArticlesScreen: View {
    @StateObject var viewModel: ArticlesViewModelWrapper

    var body: some View {
        VStack {

            if viewModel.articles.loading {

            }

            if !viewModel.articles.error.isEmpty {
                Text(viewModel.articles.error)
            }

            if (!viewModel.articles.articles.isEmpty) {
                ScrollView {
                    LazyVStack(spacing: 10) {
                        ForEach(viewModel.articles.articles) { article in
                            ArticleItemView(article: article)
                        }
                    }
                }
            }


        }
        .onAppear {
            viewModel.startObserving()
        }
    }
}
