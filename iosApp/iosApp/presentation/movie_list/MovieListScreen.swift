//
//  MovieListScreen.swift
//  iosApp
//
//  Created by Ahmed Orabi on 21/12/2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared
import SDWebImageSwiftUI

struct MovieListScreen: View {
    
    private let networkmodule : NetworkModule
    private let getMovieModule : GetMoviesModule
    
    @ObservedObject var viewModel : MovieListViewModel
    
    
    init(networkmodule : NetworkModule) {
        self.networkmodule = networkmodule
        self.getMovieModule = GetMoviesModule(networkModule: networkmodule)
        
        self.viewModel = MovieListViewModel(getMovieUseCase: getMovieModule.getMoviesUseCase)
    }
    
    var body: some View {
        
        NavigationView{
            
            ZStack{
                List{
                    ForEach(viewModel.state.movies,id: \.self.id){movie in
                        ZStack{
                            MovieCard(movie: movie)
                            NavigationLink(destination: MovieDetailScreen(movie: movie)){
                               EmptyView()
                            }
                        }
                        .listStyle(PlainListStyle())
                            .listRowInsets(EdgeInsets())
                      
                    }
                }
            }
            if viewModel.state.isLoading{
                ProgressView("Loading movies...")
            }
       
           

        }
        .navigationBarHidden(true)
       
      
        
    }
}

//struct MovieListScreen_Previews: PreviewProvider {
//    static var previews: some View {
//        MovieListScreen()
//    }
//}
