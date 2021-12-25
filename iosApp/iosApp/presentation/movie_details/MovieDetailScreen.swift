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
    
    private let movie : Movie
    let imageUrl  = "https://image.tmdb.org/t/p/w500"
    
    init(movie : Movie){
        self.movie = movie
    }
    
    var body: some View {
        ScrollView{
            VStack{
                WebImage(url: URL(string: "\(imageUrl)\(movie.backdrop_path)"))
                    .resizable()
                    .placeholder(Image(systemName: "photo"))
                    .placeholder{Rectangle().foregroundColor(.white)}
                    .indicator(.activity)
                    .transition(.fade(duration: 0.5))
                    .scaledToFit()
                    .frame(height: 250, alignment: .center)
                    .clipped()
                
                
                Text("Title : \(movie.title)")
                Spacer()
                Text("Overview : \(movie.overview)")
                Spacer()
                Text("Original Title: \(movie.original_title)")
                Spacer()
                Text("Original Language: \(movie.original_language)")
                Spacer()
                Text("Vote Count: \(movie.vote_count)")
            }
        }
   
        .navigationBarTitle(Text(movie.title), displayMode: .inline)
    }
}

