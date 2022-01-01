//
//  MovieDetailScreen.swift
//  iosApp
//
//  Created by Ahmed Orabi on 25/12/2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared
import SDWebImageSwiftUI

struct MovieDetailScreen: View {
    
    private let networkmodule : NetworkModule
    private let getMovieModule : GetMovieDetailsModule
    
    @ObservedObject var viewModel : MovieDetailViewModel
    
    private let movieId : Movie
    let imageUrl  = "https://image.tmdb.org/t/p/w500"
   
    
    init(movie : Movie , networkmodule : NetworkModule){
        self.movieId = movie
        self.networkmodule = networkmodule
        self.getMovieModule = GetMovieDetailsModule(networkModule: networkmodule)
        
        self.viewModel = MovieDetailViewModel(movieId : Int(movie.id)  , getMovieUseCase: getMovieModule.getMoviesDetailUseCase)
    }
    
    var body: some View {
        
        let movie = viewModel.state.movie
        if viewModel.state.movie != nil {
          
            ScrollView{
                VStack{
                    WebImage(url: URL(string: "\(imageUrl)\(movie!.backdrop_path)"))
                        .resizable()
                        .placeholder(Image(systemName: "photo"))
                        .placeholder{Rectangle().foregroundColor(.white)}
                        .indicator(.activity)
                        .transition(.fade(duration: 0.5))
                        .scaledToFit()
                        .frame(height: 250, alignment: .center)
                        .clipped()
                    
                    HStack(alignment: .lastTextBaseline){
                        
                        Text(String("Movie Title: \(movie!.title)"))
                            .frame(alignment: .center)
                        Spacer()
                        
                        Text(String("Vote Average: \(movie!.vote_average)"))
                            .frame(alignment: .trailing)
                    }
                    .padding(.top,4)
                    .padding(.leading,4)
                    .padding(.trailing,4)
                    .padding(.bottom,4)
                    Spacer()
                    
                    VStack{
                        Group{
                            Text("Overview : \(movie!.overview)")
                                .padding(.top,4)
                                .padding(.bottom,4)
                                .padding(.leading,4)
                                .padding(.trailing,4)
                            
                            Text("Original Language : \(movie!.original_language)")
                                .padding(.top,4)
                                .padding(.bottom,4)
                            Text("Release Date : \(movie!.release_date)")
                                .padding(.top,4)
                                .padding(.bottom,4)
                            Text("Tag Line : \(movie!.tagline)")
                                .padding(.top,4)
                                .padding(.bottom,4)
                            Text("Budget : \(movie!.budget)")
                                .padding(.top,4)
                                .padding(.bottom,4)
                            HStack{
                                 Text("Genres : ")
                                ForEach(movie!.genres! as Array<Genre>, id:\.self){ genre in
                                    Text("\(genre)")
                                }
                            }
                            .padding(.top,4)
                            .padding(.bottom,4)
                            Text("Revenue : \(movie!.revenue)")
                                .padding(.top,4)
                                .padding(.bottom,4)
                        }
                  
                    }
                    .padding(.top,4)
                    .padding(.leading,4)
                    .padding(.trailing,4)
                    .padding(.bottom,4)

                }
            }
        .navigationBarTitle(Text(movie!.title), displayMode: .inline)
        }
        
     
    }
}

