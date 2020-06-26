package exercise

class UrlMappings {

    static mappings = {
        //causes requests to be mapped to controller and action
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller:"home")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
