from flask import Flask, render_template, url_for, request, redirect, jsonify
from flask_sqlalchemy import SQLAlchemy
from datetime import datetime

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///test.db'
db = SQLAlchemy(app)
general_user=0
temp_prop=0

class User(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(200), nullable=False)
    email = db.Column(db.String(200), nullable=False)
    password = db.Column(db.String(20), nullable=False)
    date_created = db.Column(db.DateTime, default=datetime.utcnow)
    g= db.Column(db.Integer, nullable=False)
    prop = [db.Column(db.String(200)) for _ in range(10)]


class Props(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    guia = db.Column(db.String(200), nullable=False)
    turista= db.Column(db.String(200), nullable=False)
    descricao = db.Column(db.String(200), nullable=False)
    duracao = db.Column(db.String(200), nullable=False)
    hora = db.Column(db.String(200), nullable=False)
    dia = db.Column(db.String(200), nullable=False)
    capacidade = db.Column(db.Integer, nullable=False)
    preco= db.Column(db.Integer, nullable=False)
    date_created = db.Column(db.DateTime, default=datetime.utcnow)

    def __init__(self, guia, turista, descricao, duracao, hora, dia, capacidade, preco): 
        self.guia=guia
        self.turista=turista
        self.descricao=descricao
        self.duracao=duracao
        self.hora=hora
        self.dia=dia
        self.capacidade=capacidade
        self.preco=preco

    def __str__(self):
        return self.descricao+"\n"+self.hora+"\n"+self.dia


@app.route('/', methods=['POST', 'GET'])
def index():
    global general_user
    global temp_prop
    
     
    

    if request.method == 'POST':
        emailPut = request.form['emailIn']
        passwordPut = request.form['passIn']

        try:
            utilizador = User.query.filter_by(email=emailPut).first()
            passV=utilizador.password

            if passV==passwordPut:

                general_user = User.query.filter_by(email=emailPut).first()
                return redirect('/homepage')

            else:
                return redirect('/')

        except:
            print("EXCEPTION!")
            return redirect('/')


    else:
        return render_template('index.html')

@app.route('/escolher', methods=['POST','GET'])
def escolher():
    global general_user
    global temp_prop
    

    uts=User.query.order_by(User.date_created).all()
    guias= [s for s in uts if s.g==1]
    ids= [i.id for i in guias]

    if request.method=='POST':       
        for i in ids:
            if request.form.get(str(i)) == "on":
                temp_prop.guia=str(i)
                guide= User.query.filter_by(id=i).first()
                return render_template('guiaDetalhes.html', general_user=general_user, temp_prop=temp_prop, guide=guide)        
        
    return render_template('escolher_guia.html', general_user=general_user, guias=guias)

@app.route('/homepage')
def homepage():
    global general_user
    global temp_prop
    
     
    if general_user.g == 1:
        propo=Props.query.filter_by(guia=general_user.id).all()
        sz=len(propo)
        return render_template('pagina_inicialGuia.html', general_user=general_user, sz=sz)
    else:
        return render_template('pagina_inicial.html', general_user=general_user)


@app.route('/horarios',  methods=['POST','GET'])
def horarios():
    global general_user
    global temp_prop
    
    print(request.method)    


    if request.method=='POST':


        print("AQUI VAI:")
        print(request.form.get("testezao"))
        print(request.form.get("testinho"))
        temp_prop.hora=request.form.get("hour")
        temp_prop.dia=request.form.get("day")
        temp_prop.turista=general_user.id
        
        us=User.query.filter_by(id=temp_prop.guia).first()
        us2=User.query.filter_by(id=general_user.id).first()

        us.prop.append(str(temp_prop))
        us2.prop.append(str(temp_prop))
        
        db.session.commit()
        
        #general_user.prop.append(str(temp_prop))

        

        db.session.add(temp_prop)
        db.session.commit()
        #print(us.prop[-1])
        return render_template('conclusao_proposta.html', general_user=general_user)
     
    return render_template('horarios.html', general_user=general_user)



@app.route('/personalizadas', methods=['POST','GET'])
def personalizadas():
    global general_user
    global temp_prop
    i=0

    temp_prop= Props("base","","","","", "",6,0)

    print(request.method)


    if request.method=='POST':
        if request.form.get("cortico")=="on":
            temp_prop.descricao+="Restaurante Cortiço "
            i+=1

        if request.form.get("vitorino")=="on":
            temp_prop.descricao+="Restaurante O Vitorino "
            i+=1

        if request.form.get("se")=="on":
            temp_prop.descricao+="Sé de Aveiro "
            i+=1

        if request.form.get("pescadores")=="on":
            temp_prop.descricao+="Casas de Pescadores (Costa Nova) "
            i+=1

        if request.form.get("municipal")=="on":
            temp_prop.descricao+="Estádio Municipal de Aveiro "
            i+=1

        if request.form.get("mario duarte")=="on":
            temp_prop.descricao+="Estádio Mário Duarte "
            i+=1

        temp_prop.duracao=str(i)+"h"
        temp_prop.preco=i*10
        print(temp_prop.preco)
        return redirect('/escolher')



    return render_template('visitaPersonalizada.html', general_user=general_user)


@app.route('/visitaMoliceiros')
def visitaMoliceiros():
    global general_user
    global temp_prop
    
    temp_prop= Props("base","base","Visita pela bela ria de Aveiro, deixe se levar pelo balançar do moliceiro. Um dos passeios mais apreciados pelos nossos clientes","2h","", "",6,50)

     
    return render_template('visitaMoliceiros.html', general_user=general_user)



@app.route('/praias')
def praias():
    global general_user
    global temp_prop
    
    
    temp_prop= Props("base","base"," Visita pelas praias mais belas de Aveiro, o percurso passa pelas praias da Barra e Costa Nova, com um final doce ao sabor das típicas tripas de Aveiro.","2h30","", "",6,40)

    return render_template('visitaPraias.html', general_user=general_user)


@app.route('/details')
def details():
    global general_user
    global temp_prop
    
     
    return render_template('contaDetails.html', general_user=general_user)


@app.route('/changepw')
def changepw():
    global general_user
    global temp_prop
    
     
    return render_template('changePw.html', general_user=general_user)


@app.route('/guia')
def guia():
    global general_user
    global temp_prop
    
     
    return render_template('guiaDetalhes.html', general_user=general_user)



@app.route('/historico')
def historico():
    global general_user
    global temp_prop
    

    if general_user.g == 1:
        return render_template('historicoGuia.html', general_user=general_user)
    else: 
        return render_template('historico.html', general_user=general_user)



@app.route('/historicoV')
def historicoV():
    global general_user
    global temp_prop
    

    if general_user.g == 1:
        propo=Props.query.filter_by(guia=general_user.id).all()
        propo.reverse()
        return render_template('histVisitasGuia.html', general_user=general_user, propo=propo)
    else:

        propo=Props.query.filter_by(turista=general_user.id).all()
        propo.reverse()
        return render_template('histVisitas.html', general_user=general_user, propo=propo)


@app.route('/pagamentos')
def pagamentos():
    global general_user
    global temp_prop
    
    propo=Props.query.filter_by(turista=general_user.id).all()
    propo.reverse()

    return render_template('pagamentos.html', general_user=general_user, propo=propo)


@app.route('/propostas')
def propostas():
    global general_user
    global temp_prop
    
    
    propo=Props.query.filter_by(guia=general_user.id).all()
    propo.reverse()
    return render_template('propostas.html', general_user=general_user, propo=propo)



@app.route('/conclusao')
def conclusao():
    global general_user
    global temp_prop
    
     
    return render_template('conclusao_proposta.html', general_user=general_user)



@app.route('/criar', methods=['POST','GET'])
def criar():
    global general_user
    global temp_prop
    
     
    if request.method == 'POST':
        nome = request.form['name']
        email = request.form['email']
        password= request.form['pass']
        pass_check= request.form['passAgain']

        val1=request.form.get('check1')
        val2=request.form.get('check2')
       


        if password == pass_check:

            if val1 == "on":
                g=1
            
            elif val2 == "on":
                g=2

            else:
                g=0

            new = User(name= nome, email = email, password = password, g=g)
            db.session.add(new)
            db.session.commit()
            return redirect('/')

        else:
            return redirect('/criar')


    else:
        return render_template('criar_conta.html')


if __name__ == "__main__":    
    app.run(debug=True)

